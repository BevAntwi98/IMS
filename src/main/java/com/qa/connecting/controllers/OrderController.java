package com.qa.connecting.controllers;

import org.apache.log4j.Logger;

import com.qa.connecting.Action;
import com.qa.connecting.Ims;
import com.qa.connecting.model.Order;
import com.qa.connecting.services.ItemServices;
import com.qa.connecting.services.OrderServices;
import com.qa.connecting.utils.Input;

public class OrderController {
	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	private Input input;

	private OrderServices orderServices;

	public OrderController(Input input, OrderServices orderServices) {
		super();
		this.input = input;
		this.orderServices = orderServices;
	}



	public void run(Action selectedAction) {

		switch (selectedAction) {

		case CREATE: {
			System.out.println("order ID: ");
			String order_ID = input.getInput();

			System.out.print("customer ID: ");
			String customer_ID = input.getInput();

			System.out.println("total order: ");
			String quantity = input.getInput();
			
			System.out.println("order date: ");
			String date = input.getInput();

			LOGGER.info("Order Created!!");

			Order order = new Order();
			orderServices.insertOrder(order);
			break;

		}

		case READ: {
			orderServices.displayOrders();
			break;

		}

		case UPDATE: {
			System.out.println("Enter new quantity: ");
			String new_quantity = input.getInput();

			System.out.println("Enter new price: ");
			String price = input.getInput();

			Order new_order = new Order ();
			orderServices.updateOrder(new_order);
			break;

		}
		case DELETE: {
			System.out.println("Which order would you like to delete? ");

			Order delete_order = new Order();
			orderServices.deleteOrder(delete_order);

			LOGGER.info("Order deleted!");
			break;

		}
		}

	}
}


