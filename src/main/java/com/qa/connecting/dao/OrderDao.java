package com.qa.connecting.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qa.connecting.model.Customer;
import com.qa.connecting.model.Order;

public class OrderDao {
	
	private DatabaseConnection databaseConnection;

	public OrderDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}
	public void insertOrder(Order order) throws SQLException {

		String sql = "insert into order(order_ID, customer_ID, total_order, order_date) values ( ?, ?, ?, ?);";
		PreparedStatement preparedStatement = databaseConnection.getPreparedStatement(sql);
		preparedStatement.setLong(1, order.getOrder_ID());
		preparedStatement.setLong(2, order.getCustomer_ID());
		preparedStatement.setLong(3, order.getTotal_order());
		preparedStatement.setLong(4, order.getOrder_date());
		

		preparedStatement.executeUpdate();
		preparedStatement.close();
	}

	public List<Order> readAllOrders() throws SQLException {
		String sql = "SELECT * FROM orders;";

		PreparedStatement preparedStatement = databaseConnection.getPreparedStatement(sql);

		ResultSet resultSet = preparedStatement.executeQuery();

		List<Order> orders = new ArrayList<>();

		while (resultSet.next()) {
			Order order = new Order();
			order.setOrder_ID(resultSet.getInt("order_ID"));
			order.setCustomer_ID(resultSet.getInt("customer_ID"));
			order.setTotal_order(resultSet.getInt("total_order"));
			order.setOrder_date(resultSet.getLong("order_Date"));
		}
		resultSet.close();
		preparedStatement.close();
		return orders;
	}
	
	public void updateOrder(Order order) throws SQLException {
		
		
		String sql = "UPDATE orders SET total_order=? where customer_ID=1 ?";
		PreparedStatement preparedStatement = databaseConnection.getPreparedStatement(sql);
		preparedStatement.setInt(1, order.getTotal_order());
		preparedStatement.setInt(2, order.getCustomer_ID());
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
	public void deleteOrder(Order order) throws SQLException {
		String sql = "DELETE FROM ORDERS WHERE customer_ID = ?";
		PreparedStatement preparedStatement = databaseConnection.getPreparedStatement(sql);
		preparedStatement.setLong(1, order.getCustomer_ID());
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
}


