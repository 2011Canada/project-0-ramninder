package com.revature.repositories;

import java.util.List;

import com.revature.models.AccountTypes;
import com.revature.models.BankAccounts;
import com.revature.models.Customer;

public class TestAllDAO {
	
	
	
	public static void main(String[] args) {
		
//		
//		Customer c = new Customer();
////		
////		 c.setCustomerId("504");
//		UserDAO cus = new UserDAOImpl();
//		c=	cus.findCustomerById("503");
//		
//		
//		String id = c.getCustomerId();
//		String username = c.getCustomerUsername();
//
//		String password = c.getCustomerPassword();
//
//		
//		System.out.println(id);
//		System.out.println(username);
//
//		System.out.println(password);

		
		
//		c.setCustomerUsername("Alec");
//		c.setCustomerPassword("00000");
//		
//		UserDAOImpl im = new UserDAOImpl();
////		
////		im.addNewUser(c);
//		
//		List<Customer> customer = im.findAllCustomer();
//		
//		for(Customer c : customer) {
//			System.out.println(c.getCustomerUsername());
//			
//			System.out.println(c.getCustomerPassword());
//
//			}
		
		
		//Testing Account Types
//		AccountTypes ac = new AccountTypes();
//		
//		ac.setAccountType("checking");
//		ac.setId("1");
//		
//		BankTypesDAOImpl imp = new BankTypesDAOImpl();
//		imp.save(ac);

	
		BankAccounts bk = new  BankAccounts();
		
		BankAccountDAO bc = new BankAccountsDAOImpl();
		
		
		
		
		
//		bk = bc.findById("503");
//		
//		System.out.println(bk.getId());
//		System.out.println(bk.getAccountTypeId());
//		System.out.println(bk.getAccountOwner());
//		System.out.println(bk.getBalance());

		
		
		
		

		
		
	}

}
