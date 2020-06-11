package com.qa.connecting.services;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.connecting.dao.CustomerDao;
import com.qa.connecting.model.Customer;

public class CustomerServices {
	
	public static final Logger LOGGER = Logger.getLogger(CustomerServices.class);
	
	private CustomerDao customerDao;

	public CustomerServices(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}
	
	public void displayCustomers() {
		try {
			List<Customer> customers = customerDao.readAllCustomers();
			for(Customer customer : customers) {
				LOGGER.info(customer);
			}
			
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for (StackTraceElement element: e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
	}
	
	public void insertCustomer(Customer customer) {
		try {
			customerDao.insertCustomer(customer);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for (StackTraceElement element: e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
	}
	
    public void updateCustomer (Customer customer) {
    	try {
    		customerDao.updateCustomer(customer);
    	} catch (SQLException e) {
    		LOGGER.error(e.getMessage());
			for (StackTraceElement element: e.getStackTrace()) {
				LOGGER.debug(element);
    	}
    }
}

    public void deleteCustomer (Customer customer) {
    	try {
    		customerDao.deleteCustomer(customer);
    	} catch (SQLException e) {
    		LOGGER.error(e.getMessage());
			for (StackTraceElement element: e.getStackTrace()) {
				LOGGER.debug(element);
			}
    	}
    }
}
