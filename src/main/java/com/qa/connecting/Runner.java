package com.qa.connecting;

import com.qa.connecting.dao.DatabaseConnection;
import com.qa.connecting.dao.RemoteDatabaseConnection;
import com.qa.connecting.utils.Input;

public class Runner {
	public static void main(String[] args) {
		Input input = new Input();
		System.out.println("Database username: ");
		String user = input.getInput();
		System.out.println("Database password: ");
		String password = input.getInput();

		DatabaseConnection connection = new RemoteDatabaseConnection(user, password);
		
		Ims ims = new Ims(input, connection);
		ims.menu();
		connection.closeConnection();

	}
		
}
