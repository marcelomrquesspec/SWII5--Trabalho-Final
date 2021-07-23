//marcelocb3005631*ifsp//
package net.codejava.javaee.bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class OrderDAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	
	
	public OrderDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = "jdbc:mysql://localhost:3306";
		this.jdbcUsername = "root";
		this.jdbcPassword = "root";
	}
	
	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				jdbcURL = "jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC";
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(
										jdbcURL, jdbcUsername, jdbcPassword);
		}
	}
	
	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	public boolean insertOrder(Order salesman) throws SQLException {
		String sql = "INSERT INTO order (name, city, commission) VALUES (?, ?, ?)";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, order.getOrder_no());
		statement.setString(2, order.getPurch_amt());
		statement.setFloat(3, order.getOrder_date());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public List<Order> listAllOrder() throws SQLException {
		List<Order> listOrder = new ArrayList<>();
		
		String sql = "SELECT * FROM order";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int id = resultSet.getInt("order_id");
			String name = resultSet.getString("order_nro");
			String city = resultSet.getString("purch_amt");
			float commission = resultSet.getFloat("ord_date");
			
			Order order = new Order(id, order_no, purch_amt, ord_date);
			listOrder.add(order);
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listOrder;
	}
	
	public boolean deleteOrder(Order order) throws SQLException {
		String sql = "DELETE FROM order where order_id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, order.getId());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
	public boolean updateOrder(Order order) throws SQLException {
		String sql = "UPDATE order SET order_nro = ?, purch_amt = ?, ord_date = ?";
		sql += " WHERE order_id = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, order.getOrder_Nro());
		statement.setString(2, order.getPurch_Amt());
		statement.setFloat(3, order.getOrd_Date());
		statement.setInt(4, order.getId());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
	public Order getOrder(int id) throws SQLException {
		Order order = null;
		String sql = "SELECT * FROM order WHERE order_id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			String name = resultSet.getString("order_no");
			String city = resultSet.getString("purch_amt");
			float commission = resultSet.getFloat("ord_date");
			
			order = new Order(id, name, city, commission);
		}
		
		resultSet.close();
		statement.close();
		
		return order;
	}//fimmm---->>>
	
	public class CustomerDAO {
		private String jdbcURL;
		private String jdbcUsername;
		private String jdbcPassword;
		private Connection jdbcConnection;
		
		public CustomerDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
			this.jdbcURL = "jdbc:mysql://localhost:3306";
			this.jdbcUsername = "root";
			this.jdbcPassword = "root";
		}
		
		protected void connect() throws SQLException {
			if (jdbcConnection == null || jdbcConnection.isClosed()) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					jdbcURL = "jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC";
				} catch (ClassNotFoundException e) {
					throw new SQLException(e);
				}
				jdbcConnection = DriverManager.getConnection(
											jdbcURL, jdbcUsername, jdbcPassword);
			}
		}
		
		protected void disconnect() throws SQLException {
			if (jdbcConnection != null && !jdbcConnection.isClosed()) {
				jdbcConnection.close();
			}
		}
		
		public boolean insertCustomer(Customer customer) throws SQLException {
			String sql = "INSERT INTO customer (title, city, grade) VALUES (?, ?, ?)";
			connect();
			
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setString(1, customer.getCust_Name());
			statement.setString(2, customer.getCity());
			statement.setFloat(3, customer.getGrade());
			
			boolean rowInserted = statement.executeUpdate() > 0;
			statement.close();
			disconnect();
			return rowInserted;
		}
		
		public List<Customer> listAllCustomers() throws SQLException {
			List<Customer> listCustomer = new ArrayList<>();
			
			String sql = "SELECT * FROM customer";
			
			connect();
			
			Statement statement = jdbcConnection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				int id = resultSet.getInt("customer_id");
				String cust_name = resultSet.getString("cust_name");
				String city = resultSet.getString("city");
				float grade = resultSet.getFloat("grade");
				
				Customer customer = new Customer(id, cust_name, city, grade);
				listCustomer.add(customer);
			}
			
			resultSet.close();
			statement.close();
			
			disconnect();
			
			return listCustomer;
		}
		
		public boolean deleteCustomer(Customer customer) throws SQLException {
			String sql = "DELETE FROM customer where customer_id = ?";
			
			connect();
			
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setInt(1, customer.getId());
			
			boolean rowDeleted = statement.executeUpdate() > 0;
			statement.close();
			disconnect();
			return rowDeleted;		
		}
		
		public boolean updateCustomer(Customer customer) throws SQLException {
			String sql = "UPDATE customer SET cust_name = ?, city = ?, grade = ?";
			sql += " WHERE customer_id = ?";
			connect();
			
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setString(1, customer.getCust_Name());
			statement.setString(2, customer.getCity());
			statement.setFloat(3, customer.getGrade());
			statement.setInt(4, customer.getId());
			
			boolean rowUpdated = statement.executeUpdate() > 0;
			statement.close();
			disconnect();
			return rowUpdated;		
		}
		
		public Customer getCustomer(int id) throws SQLException {
			Customer customer = null;
			String sql = "SELECT * FROM customer WHERE customer_id = ?";
			
			connect();
			
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				String cust_name = resultSet.getString("cust_name");
				String city = resultSet.getString("city");
				float grade = resultSet.getFloat("grade");
				
				customer = new Customer(id, cust_name, city, grade);
			}
			
			resultSet.close();
			statement.close();
			
			return customer;
		}
		
	}
	
	
		

	}	
