package com.qa.connecting.dao;

import com.qa.connecting.model.Order;

public class OrderDao {
	
	private DatabaseConnection databaseConnection;

	public OrderDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void insertOrder(Order order) {
		String sql = "insert into orders (total_order, order_date) values ('" + order.getTotal_order() + "', '" + 
	order.getOrder_date() + "')";
		
		System.out.println(sql);
		databaseConnection.sendUpdate(sql);
	}

}

