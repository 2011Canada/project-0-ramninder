package com.revature.service;

import java.util.List;

import com.revature.models.Customer;

public interface ServiceToCustomer {
	
	
	public Customer addNewCustomer(String customerId, String username, String password );
	
	public List<Customer> findAllCustomer();
	
	public Customer findCustomer(String id);
	
	
	
}
