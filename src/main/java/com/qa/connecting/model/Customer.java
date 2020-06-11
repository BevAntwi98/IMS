package com.qa.connecting.model;

public class Customer {

	private int id;
	private String customer_name;
	private String customer_lastname;
	private String email;
	private String address;
	private String password;
	
	public Customer() {

	}

	public Customer(String customer_name, String customer_lastname, String email, String address, String password) {
		super();
		this.customer_name = customer_name;
		this.customer_lastname = customer_lastname;
		this.email = email;
		this.address = address;
		this.password=password;
	}

	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customer_name=" + customer_name + ", customer_lastname=" + customer_lastname
				+ ", email=" + email + ", address=" + address + ", password=" + password + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	
	public String getCustomer_lastname() {
		return customer_lastname;
	}

	public void setCustomer_lastname(String customer_lastname) {
		this.customer_lastname = customer_lastname;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

	
}
