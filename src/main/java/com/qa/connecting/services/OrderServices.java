package com.qa.connecting.services;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.connecting.dao.CustomerDao;
import com.qa.connecting.dao.OrderDao;

import com.qa.connecting.model.Order;

public class OrderServices {
	
	public static final Logger LOGGER = Logger.getLogger(CustomerServices.class);
	
	private OrderDao orderDao;

	public OrderServices(OrderDao orderDao) {
		super();
		this.orderDao = orderDao;
	}
	
	public void displayOrders() {
		try {
			List<Order> orders = orderDao.readAllOrders();
			for(Order order : orders) {
				LOGGER.info(order);
			}
			
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for (StackTraceElement element: e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
	}
	
	public void insertOrder(Order order) {
		try {
			orderDao.insertOrder(order);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for (StackTraceElement element: e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
	}

	public void updateOrder(Order new_order) {
		try {
			orderDao.updateOrder(order);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			for (StackTraceElement element: e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
		
		public void deleteOrder(Order new_order) {
			try {
				orderDao.deleteOrder(order);
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				for (StackTraceElement element: e.getStackTrace()) {
					LOGGER.debug(element);
				}
			}
	}

}
