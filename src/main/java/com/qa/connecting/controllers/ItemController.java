package com.qa.connecting.controllers;


import org.apache.log4j.Logger;

import com.qa.connecting.Action;
import com.qa.connecting.Ims;
import com.qa.connecting.utils.Input;

public class ItemController {

	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	static Input input = new Input();


	public static void main(String[] args) {

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

		switch (selectedAction) {

		case CREATE: {
			System.out.println("item name: ");
			String item_name = input.getInput();

			System.out.print("item price: ");
			String item_price = input.getInput();

			System.out.println("quantity: ");
			String quantity = input.getInput();
			LOGGER.info("Item created!");
					

			
		}
		
		case READ: {
		//
			
		}
		
		case UPDATE: {
			//
		}
		case DELETE: {
			
		}
}
		
		
}
}