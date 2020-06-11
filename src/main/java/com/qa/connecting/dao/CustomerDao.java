package com.qa.connecting.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qa.connecting.model.Customer;

public class CustomerDao {

	private DatabaseConnection databaseConnection;

	public CustomerDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void insertCustomer(Customer customer) throws SQLException {

		String sql = "insert into customer(customer_name, customer_lastname, email, address, password) values ( ?, ?, ?, ?, ?);";
		PreparedStatement preparedStatement = databaseConnection.getPreparedStatement(sql);
		preparedStatement.setString(1, customer.getCustomer_name());
		preparedStatement.setString(2, customer.getCustomer_lastname());
		preparedStatement.setString(3, customer.getEmail());
		preparedStatement.setString(4, customer.getAddress());
		preparedStatement.setString(5, customer.getPassword());

		preparedStatement.executeUpdate();
		preparedStatement.close();
	}

	public List<Customer> readAllCustomers() throws SQLException {
		String sql = "SELECT * FROM customer;";

		PreparedStatement preparedStatement = databaseConnection.getPreparedStatement(sql);

		ResultSet resultSet = preparedStatement.executeQuery();

		List<Customer> customers = new ArrayList<>();

		while (resultSet.next()) {
			Customer customer = new Customer();
			customer.setId(resultSet.getInt("customer_ID"));
			customer.setCustomer_name(resultSet.getString("customer_name"));
			customer.setCustomer_lastname(resultSet.getString("customer_lastname"));
			customers.add(customer);
		}
		resultSet.close();
		preparedStatement.close();
		return customers;
	}
	
	public void updateCustomer(Customer customer) throws SQLException {
		
		
		String sql = "UPDATE customer SET customer_name= ?, customer_lastname =?, email=?, address=?, password=? WHERE customer_ID=?";
		PreparedStatement preparedStatement = databaseConnection.getPreparedStatement(sql);
		preparedStatement.setString(1, customer.getCustomer_name());
		preparedStatement.setString(2, customer.getCustomer_lastname());
		preparedStatement.setString(3, customer.getEmail());
		preparedStatement.setString(4, customer.getAddress());
		preparedStatement.setString(5, customer.getPassword());
		preparedStatement.setInt(6, customer.getId());
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
	public void deleteCustomer(String customerName) throws SQLException {
		String sql = "DELETE FROM CUSTOMER WHERE customer_name = ?";
		PreparedStatement preparedStatement = databaseConnection.getPreparedStatement(sql);
		preparedStatement.setString(1,customerName);
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}

}
