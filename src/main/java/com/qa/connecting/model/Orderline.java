package com.qa.connecting.model;

public class Orderline {
	
	private int order_ID;
	private int item_ID;
	private int quantity_ordered;
	
	public Orderline(int order_ID, int item_ID, int quantity_ordered ) {
		super();
		
	this.order_ID = order_ID;
	this.item_ID = item_ID;
	this.quantity_ordered = quantity_ordered;
		
		
	}

	public int getOrder_ID() {
		return order_ID;
	}

	public void setOrder_ID(int order_ID) {
		this.order_ID = order_ID;
	}

	public int getItem_ID() {
		return item_ID;
	}

	public void setItem_ID(int item_ID) {
		this.item_ID = item_ID;
	}

	public int getQuantity_ordered() {
		return quantity_ordered;
	}

	public void setQuantity_ordered(int quantity_ordered) {
		this.quantity_ordered = quantity_ordered;
	}
}	
