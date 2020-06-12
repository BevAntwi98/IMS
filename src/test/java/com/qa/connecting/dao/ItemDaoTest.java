package com.qa.connecting.dao;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


import com.qa.connecting.model.Item;

public class ItemDaoTest {
	
		
		static DatabaseConnection databaseConnection;
		static final String SCHEMA_LOCATION = "src\\test\\resources\\ims schema.sql";
		static final String DATA_LOCATION = "src\\test\\resources\\ims table.sql";
		static final String CLEAR_LOCATION = "src\\test\\resources\\ClearDB.sql";
		static final String DROP_LOCATION = "src\\test\\resources\\DropDB.sql";
		
		private static void sendToDB(Connection connection, String fileLocation) {
			try (BufferedReader br = new BufferedReader(new FileReader(fileLocation));) {
				String string;
				while ((string = br.readLine()) != null) {
					try (Statement statement = connection.createStatement();) {
						statement.executeUpdate(string);
					}
				}
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		}
		
		@BeforeClass
		public static void init() throws SQLException {
			sendToDB(DriverManager.getConnection("jdbc:mysql://35.246.104.154:3306", "root", "root"), SCHEMA_LOCATION);
		}
		
		@Before
		public void setup() {
			databaseConnection = new TestingDatabaseConnection("root","root");
			sendToDB(databaseConnection.getConnection(), DATA_LOCATION);
		}
		
		@After
		public void teardown() throws SQLException {
			sendToDB(DriverManager.getConnection("jdbc:mysql://35.246.104.154/testdb:3306", "root", "root"),CLEAR_LOCATION);
		}
		
		@AfterClass
		public static void finish() throws SQLException {
			sendToDB(DriverManager.getConnection("jdbc:mysql://35.246.104.154:3306", "root", "root"), DROP_LOCATION);
			databaseConnection.closeConnection();
		}
		
		@Ignore
		@Test
		public void test() throws SQLException {
			ItemDao itemDao = new ItemDao(databaseConnection);
			Item test = new Item("Cheese", 4, 1);
			itemDao.insertItem(test);
			
			String query = "SELECT * FROM item";
			
			ResultSet rs = databaseConnection.sendQuery(query);
			int count = 0;
			while (rs.next()) {
				count++;
			}
			
			assertEquals(4, count);
		}

	}


