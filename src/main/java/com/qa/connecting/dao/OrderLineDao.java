package com.qa.connecting.dao;


import com.qa.connecting.model.Orderline;

public class OrderLineDao {

	private DatabaseConnection databaseConnection;

	public OrderLineDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void insertOrderLine(Orderline orderline) {
		String sql = "insert into orderline (order_ID, item_ID, quantity_ordered) values ('" + orderline.getOrder_ID() + "', '" + orderline.getItem_ID() + "' , '"  
	+ orderline.getQuantity_ordered() + "')";
		
		System.out.println(sql);
		databaseConnection.sendUpdate(sql);
	}
}
