package com.revature.models;

public class Customer {
	
	private String name;
	private String username;
	private String password;
	private int id;
	
	
	
	public Customer() {
		
		
	}
	
	public Customer(String name, String username, String password, int id) {
		
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
