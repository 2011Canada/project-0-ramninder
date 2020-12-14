package com.revature.service;

import java.util.List;

import com.revature.models.Customer;
import com.revature.repositories.UserDAO;
import com.revature.repositories.UserDAOImpl;

public class ServiceToCustomerImpl implements ServiceToCustomer {
		
	 Customer customer = new Customer();;
	 
	static  UserDAO user = new UserDAOImpl();

	@Override
	public Customer addNewCustomer(String customerId, String username, String password) {
		
		customer.setCustomerId(customerId);
		customer.setCustomerUsername(username);
		customer.setCustomerPassword(password);
		
		
		return user.addNewUser(customer);
		
	}

	@Override
	public List<Customer> findAllCustomer() {
		return user.findAllCustomer();
	}

	@Override
	public Customer findCustomer(String id) {
		
		return user.findCustomerById(id);
	}
	
	
	
	

}
