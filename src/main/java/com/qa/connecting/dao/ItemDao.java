package com.qa.connecting.dao;

import com.qa.connecting.model.Item;

public class ItemDao {
	private DatabaseConnection databaseConnection;

	public ItemDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void insertItem(Item item) {
		String sql = "insert into item(item name, quantity , total price) values ('" + item.getItem_name() + "', '"
				+ item.getQuantity() + "', '" + item.getTotal_price() + "');";

		databaseConnection.sendUpdate(sql);
	}
	

}


