package com.revature.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.BankAccounts;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.EmployeeDAOImpl;
import com.revature.service.EmployeeSrevice;
import com.revature.service.ServiceToCustomer;
import com.revature.service.ServiceToCustomerImpl;


public class EmployeeMenu {
	
	
	static EmployeeDAO userdata = new EmployeeDAOImpl();
	static EmployeeSrevice serviceEmp = new EmployeeSrevice();	
	static ServiceToCustomer service = new ServiceToCustomerImpl();	

	
//Employee Login	
public static void loginScreen() {
		
		String username;
		String password;
		boolean checkUser = false;
		System.out.println("Employee Login Screen");
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your username:");
		username = input.nextLine();
		
		//check username for empty string or null
		if (username.equals("") || username.isEmpty()) {
					
			System.out.println("Invalid username");
			loginScreen();		
		}
		
		System.out.println("Enter your password");
		password = input.nextLine();
		
		//check password for empty string or null
		if (password.equals("") || password.isEmpty()) {
			
			System.out.println("Invalid password");
			loginScreen();
			
		}
		
		List<Employee> employee= serviceEmp.findAllEmployee();
		
		for(Employee c : employee) {
			if(c.getUsername().equals(username) && c.getPassword().equals(password)) {
				checkUser = true;
				System.out.println("You have successfully logged in");
				seeAllcustomer();
				break;
			}
		}
		
		if(!checkUser) {
			System.out.println("Username or Password is incorrect, please try again.");
			loginScreen();
		}

	}

	//See all Customer accounts
	public static void seeAllcustomer() {
		
		System.out.println("See all Customers account");
		
		List<BankAccounts> bk_Acc = serviceEmp.findAllBankAcc();
		

		for(BankAccounts bc : bk_Acc) {
			
			String id = bc.getId();
			int accountTypeId = bc.getAccountTypeId();
			String accountOwner = bc.getAccountOwner();
			double balance = bc.getBalance();
			System.out.println("id = "+id);
			System.out.println("Account Type = "+accountTypeId);
			System.out.println("Account Owner = "+ accountOwner);
			System.out.println("Balance  = "+balance);
			logout(id);
		}
			

	}
	
	//Delete customer account
	
	public static void delete() {
		
		Scanner input = new Scanner(System.in);
		
		String id = input.nextLine();
		
		
		
	}
	
	
	
	//Logout Menu
		public static void logout(String id) {

			Scanner input = new Scanner(System.in);
			
			int choice;
			
			System.out.println("Would you like to: "
					+ "\n 1. Logout"
					+ "\n 2. Go back to Customers account");
			
			
			choice = input.nextInt();
			
			switch (choice ) {
			
				case 1:
					System.out.println("Goodbye.");
					//Clear the console
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.exit(0);
					break;
				
				case 2:
					seeAllcustomer();
					break;
				
				default:
					System.out.println("Not a valid choice");
					break;
			
			}
			
			
		}


}
