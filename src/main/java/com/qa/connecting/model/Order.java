package com.qa.connecting.model;

public class Order {
	
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

}
