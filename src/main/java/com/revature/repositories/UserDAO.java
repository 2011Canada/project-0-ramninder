package com.revature.repositories;

import java.util.List;

import com.revature.models.Customer;

public interface UserDAO {
	
	public Customer addNewUser(Customer obj);
	
	public List<Customer> findAllCustomer();
	
	public Customer findCustomerById(String id);
}
