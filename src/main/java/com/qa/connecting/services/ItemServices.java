package com.qa.connecting.services;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.connecting.dao.ItemDao;
import com.qa.connecting.model.Item;

public class ItemServices {

public static final Logger LOGGER = Logger.getLogger(CustomerServices.class);
	
	private ItemDao itemDao;

	public ItemServices(ItemDao itemDao) {
		super();
		this.itemDao = itemDao;
	}
	
	public void displayItems() {
		try {
			List<Item> items = itemDao.readAllItems();
			for(Item item : items) {
				LOGGER.info(item);
			}
			
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for (StackTraceElement element: e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
	}
	
	public void insertItem(Item item) {
		try {
			itemDao.insertItem(item);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for (StackTraceElement element: e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
	}
	
    public void updateItem (Item item) {
    	try {
    		itemDao.updateItem(item);
    	} catch (SQLException e) {
    		LOGGER.error(e.getMessage());
			for (StackTraceElement element: e.getStackTrace()) {
				LOGGER.debug(element);
    	}
    }
}

    public void deleteItem (Item item) {
    	try {
    		itemDao.deleteItem(item);
    	} catch (SQLException e) {
    		LOGGER.error(e.getMessage());
			for (StackTraceElement element: e.getStackTrace()) {
				LOGGER.debug(element);
			}
    	}
    }

	
}

