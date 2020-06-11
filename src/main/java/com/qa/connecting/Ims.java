package com.qa.connecting;

import org.apache.log4j.Logger;

import com.qa.connecting.controllers.CustomerController;
import com.qa.connecting.dao.CustomerDao;
import com.qa.connecting.dao.DatabaseConnection;
import com.qa.connecting.services.CustomerServices;
import com.qa.connecting.utils.Input;

public class Ims {
	
	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	private Input input;
	private DatabaseConnection connection;
	
	public Ims(Input input, DatabaseConnection connection) {
		super();
		this.input = input;
		this.connection = connection;
	}

	public void menu() {

		System.out.println("MENU: Please select from the following: ");
     //	case CUSTOMERS:
		CustomerController  customerController = new CustomerController(input, new CustomerServices(new CustomerDao(connection)));
		customerController.run(getUserAction());
//		break;
//		case ITEMS:
//		ItemController itemController =  new ItemController(input, new ItemServices(new ItemDao(connection)));
	//	item controller.run(getUserAction())
	//}
	
	public Action getUserAction() {
		System.out.println("What would you like to do? : ");
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
