package com.qa.connecting.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qa.connecting.model.Customer;
import com.qa.connecting.model.Item;

public class ItemDao {
	private DatabaseConnection databaseConnection;

	public ItemDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void insertItem(Item item) throws SQLException {

		String sql = "insert into item (item_name, quantity, total_price) values ( ?, ?, ?);";
		PreparedStatement preparedStatement = databaseConnection.getPreparedStatement(sql);
		preparedStatement.setString(1, item.getItem_name());
		preparedStatement.setLong(2, item.getQuantity());
		preparedStatement.setLong(3, item.getTotal_price());
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}

	public List<Item> readAllItems() throws SQLException {
		String sql = "SELECT * FROM item;";

		PreparedStatement preparedStatement = databaseConnection.getPreparedStatement(sql);

		ResultSet resultSet = preparedStatement.executeQuery();

		List<Item> items = new ArrayList<>();

		while (resultSet.next()) {
			
			Item item = new Item();
			item.setID(resultSet.getInt("item_ID"));
			item.setItem_name(resultSet.getString("item_name"));
			item.setQuantity(resultSet.getInt("quantity"));
			item.setTotal_price(resultSet.getInt("total_price"));
			items.add(item);
		}
		resultSet.close();
		preparedStatement.close();
		return items;
	}
	
	public void updateItem(Item item) throws SQLException {
		
		
		String sql = "UPDATE item SET quantity= ? WHERE item_name=?";
		PreparedStatement preparedStatement = databaseConnection.getPreparedStatement(sql);
		preparedStatement.setInt(1, item.getQuantity());
		preparedStatement.setString(2,item.getItem_name());
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
	public void deleteItem(Item item) throws SQLException {
		String sql = "DELETE FROM item WHERE item_ID = ?";
		PreparedStatement preparedStatement = databaseConnection.getPreparedStatement(sql);
		preparedStatement.setInt(1, item.getID());;
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}

}


