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

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SalesmanDAO salesmanDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		salesmanDAO = new SalesmanDAO(jdbcURL, jdbcUsername, jdbcPassword);

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
				insertSalesman(request, response);
				break;
			case "/delete":
				deleteSalesman(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateSalesman(request, response);
				break;
			default:
				listSalesman(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listSalesman(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Salesman> listSalesman = salesmanDAO.listAllSalesman();
		request.setAttribute("listSalesman", listSalesman);
		RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Salesman existingSalesman = salesmanDAO.getSalesman(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanForm.jsp");
		request.setAttribute("salesman", existingSalesman);
		dispatcher.forward(request, response);

	}

	private void insertSalesman(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));

		Salesman newSalesman = new Salesman(title, author, price);
		salesmanDAO.insertSalesman(newSalesman);
		response.sendRedirect("list");
	}

	private void updateSalesman(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));

		Salesman salesman = new Salesman(id, title, author, price);
		salesmanDAO.updateSalesman(salesman);
		response.sendRedirect("list");
	}

	private void deleteSalesman(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Salesman salesman = new Salesman(id);
		salesmanDAO.deleteSalesman(salesman);
		response.sendRedirect("list");

	}

}