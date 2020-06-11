package com.qa.connecting.model;

public class Item {

	private String item_name;
	private int quantity;
	private int total_price;
	
	public Item(String item_name, int quantity, int total_price) {
		super();
		this.setItem_name(item_name);
		this.quantity=quantity;
		this.total_price=total_price;
	}

	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}



	public String getItem_name() {
		return item_name;
	}



	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
}