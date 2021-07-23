//marcelocb3005631*ifsp//
package net.codejava.javaee.bookstore;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDAO orderDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		orderDAO = new OrderDAO(jdbcURL, jdbcUsername, jdbcPassword);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertOrder(request, response);
				break;
			case "/delete":
				deleteOrder(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateOrder(request, response);
				break;
			default:
				listOrder(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listOrder(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Order> listOrder = orderDAO.listAllOrder();
		request.setAttribute("listOrder", listOrder);
		RequestDispatcher dispatcher = request.getRequestDispatcher("OrderList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("OrderForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Order existingOrder = orderDAO.getOrder(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("OrderForm.jsp");
		request.setAttribute("order", existingOrder);
		dispatcher.forward(request, response);

	}

	private void insertOrder(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String order_nro = request.getParameter("order_no");
		String purch_amt = request.getParameter("purch_AMT");
		float ord_date = Float.parseFloat(request.getParameter("ord_date"));

		Order newOrder = new Order(order_nro, purch_amt, ord_date);
		orderDAO.insertOrder(newOrder);
		response.sendRedirect("list");
	}

	private void updateOrder(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String order_nro = request.getParameter("order_nro");
		String purch_amt = request.getParameter("purch_amt");
		float ord_date = Float.parseFloat(request.getParameter("ord_date"));

		Order order = new Order(id, order_nro, purch_amt, ord_date);
		orderDAO.updateOrder(order);
		response.sendRedirect("list");
	}

	private void deleteOrder(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Order order = new Order(id);
		orderDAO.deleteOrder(order);
		response.sendRedirect("list");

	}

}