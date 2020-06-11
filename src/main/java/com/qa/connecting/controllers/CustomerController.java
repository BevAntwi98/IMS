package com.qa.connecting.controllers;

import org.apache.log4j.Logger;

import com.qa.connecting.Action;
import com.qa.connecting.model.Customer;
import com.qa.connecting.services.CustomerServices;
import com.qa.connecting.utils.Input;

public class CustomerController{

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);
	
	private Input input;
	
	private CustomerServices customerServices;

	public CustomerController(Input input, CustomerServices customerServices) {
		super();
		this.input = input;
		this.customerServices = customerServices;
	}	

	public void run(Action selectedAction) {
		switch (selectedAction) {
		case CREATE: {

			LOGGER.info("customer name:");
			String name = input.getInput();

			LOGGER.info("customer last name");
			String last_name = input.getInput();

			LOGGER.info("customer email:");
			String email = input.getInput();

			LOGGER.info("customer address:");
			String address = input.getInput();

			LOGGER.info("customer password");
			String customer_password = input.getInput();

			Customer customer = new Customer(name, last_name, email, address, customer_password);

			customerServices.insertCustomer(customer);
			break;
		}

		case READ:
			customerServices.displayCustomers();
			break;

		case UPDATE: {
			System.out.println("New Customer Name: ");
			String new_name = input.getInput();

			System.out.print("New Customer Last Name: ");
			String new_lastname = input.getInput();

			System.out.println("New Customer Password: ");
			String new_password = input.getInput();

			System.out.println("Customer details updated!");

			Customer new_customer = new Customer(new_name, new_lastname, null, null, new_password);

			break;
		}

		case DELETE:
			System.out.println("Which customer would you like to delete? ");
			String name_to_delete = input.getInput();
			
			LOGGER.info("Customer deleted!");
			break;

		default:
			LOGGER.warn("invalid selection");

		}

	}

}
