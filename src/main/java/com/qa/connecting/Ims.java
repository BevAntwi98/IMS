package com.qa.connecting;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

import com.qa.connecting.controllers.CustomerController;
import com.qa.connecting.controllers.ItemController;
import com.qa.connecting.controllers.OrderController;
import com.qa.connecting.dao.CustomerDao;
import com.qa.connecting.dao.DatabaseConnection;
import com.qa.connecting.dao.ItemDao;
import com.qa.connecting.dao.OrderDao;
import com.qa.connecting.services.CustomerServices;
import com.qa.connecting.services.ItemServices;
import com.qa.connecting.services.OrderServices;
import com.qa.connecting.utils.Input;

public class Ims {

	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	private Input input;
	private DatabaseConnection connection;

	private int selectedAction;


	public Ims(Input input, DatabaseConnection connection) {
		super();
		this.input = input;
		this.connection = connection;
	}

	public void menu() {

	//	switch (selectedAction) {

		//case CUSTOMERS:

			CustomerController customerController = new CustomerController(input,
					new CustomerServices(new CustomerDao(connection)));
			customerController.run(getUserAction());
			

		//case ITEMS:
			ItemController itemController = new ItemController(input, new ItemServices(new ItemDao(connection)));
			itemController.run(getUserAction());
			
		//case ORDER:
			OrderController ordercontroller = new OrderController(input,new OrderServices(new OrderDao(connection)));
			ordercontroller.run(getUserAction());
	
		}

	

	Action getmenu() {
		System.out.println("Please select from the menu:");
		for (Action action : Action.values()) {
			System.out.println(action.name());
		}
		System.out.println("---");

		Action selectedAction;
		while (true) {
			try {
				String actionInput = input.getInput();
				selectedAction = Action.valueOf(actionInput.toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.warn("Incorrect entry. Please re-enter: ");
			}
		}

		return selectedAction;
	}

	public Action getUserAction() {
		LOGGER.info("What would you like to do? : ");
		for (Action action : Action.values()) {
			System.out.println(action.name());
		}
		System.out.println("---");

		Action selectedAction;
		while (true) {
			try {
				String actionInput = input.getInput();
				selectedAction = Action.valueOf(actionInput.toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.warn("Incorrect entry. Please re-enter: ");
			}
		}

		return selectedAction;
	}
}
