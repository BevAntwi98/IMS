package com.qa.connecting.model;

public class Order {
	
	private int order_ID;
	private int customer_ID;
	private int total_order;
	private long order_date;
	
	public Order(int total_order, int order_date) {
		super();
		this.total_order = total_order;
		this.order_date = order_date;
	
		
	}

	public int getTotal_order() {
		return total_order;
	}

	public void setTotal_order(int total_order) {
		this.total_order = total_order;
	}

	public long getOrder_date() {
		return order_date;
	}

	public void setOrder_date(long order_date) {
		this.order_date = order_date;
	}

	public int getOrder_ID() {
		return order_ID;
	}

	public void setOrder_ID(int order_ID) {
		this.order_ID = order_ID;
	}

	public int getCustomer_ID() {
		return customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID ;
	}

}
