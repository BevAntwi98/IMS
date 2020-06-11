package com.qa.connecting.controllers;

import org.apache.log4j.Logger;

import com.qa.connecting.Action;
import com.qa.connecting.Ims;
import com.qa.connecting.model.Item;
import com.qa.connecting.services.CustomerServices;
import com.qa.connecting.services.ItemServices;
import com.qa.connecting.utils.Input;

public class ItemController {

	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	private Input input;

	private ItemServices itemServices;

	public ItemController(Input input, ItemServices itemServices) {
		super();
		this.input = input;
		this.itemServices = itemServices;
	}



	public void run(Action selectedAction) {

		switch (selectedAction) {

		case CREATE: {
			System.out.println("item name: ");
			String item_name = input.getInput();

			System.out.print("item price: ");
			String item_price = input.getInput();

			System.out.println("quantity: ");
			String quantity = input.getInput();

			LOGGER.info("Item created!");

			Item item = new Item();
			itemServices.insertItem(item);
			break;

		}

		case READ: {
			itemServices.displayItems();
			break;

		}

		case UPDATE: {
			System.out.println("Enter new quantity: ");
			String new_quantity = input.getInput();

			System.out.println("Enter new price: ");
			String price = input.getInput();

			Item new_item= new Item ();
			itemServices.updateItem(new_item);
			break;

		}
		case DELETE: {
			System.out.println("What item would you like to delete? ");

			Item delete_item = new Item();
			itemServices.deleteItem(delete_item);

			LOGGER.info("Item deleted!");
			break;

		}
		}

	}
}
