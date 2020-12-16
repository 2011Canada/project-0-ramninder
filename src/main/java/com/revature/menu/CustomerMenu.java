package com.revature.menu;

import java.util.List;
import java.util.Scanner;

import com.revature.launcher.MainLauncher;
import com.revature.models.AccountTypes;
import com.revature.models.BankAccounts;
import com.revature.models.Customer;
import com.revature.repositories.UserDAO;
import com.revature.repositories.UserDAOImpl;
import com.revature.service.BankingService;
import com.revature.service.ServiceToCustomer;
import com.revature.service.ServiceToCustomerImpl;

public class CustomerMenu {
	
	
	static UserDAO userdata = new UserDAOImpl();
	static ServiceToCustomer service = new ServiceToCustomerImpl();	
	static BankingService bankService = new BankingService();
	
	public static void customerEntry() {
		
		
		System.out.println("Hello dear Customer"
							+"\n 1. Login"
							+"\n 2. Create a New Account");
		
		Scanner input  = new Scanner(System.in);

		//Check User input for switch case.
		int choice = input.nextInt();
		
		switch(choice) {
		
		case 1:
			loginScreen();
		break;
			
		case 2:
			createAccount();
		break;
		
		default:
			System.out.println("Enter a valid choice");
			customerEntry();
			break;
		}
		
	}
	
	
	//public static void login()
	
	
	//Create new user account
	public static void createAccount() {
		
		//User fields
		String customerId;
		String username;
		String password;
		System.out.println("Create new account");

		
		Scanner input  = new Scanner(System.in);
		
		System.out.println("Create your id");
		customerId = input.nextLine();
		
		
		
		System.out.println("Create  username");
		username = input.nextLine();
		
		
		System.out.println("Create password ");
		password = input.nextLine();

		
		List<Customer> customer = service.findAllCustomer();
		boolean checkUser = false;
		for(Customer c : customer) {
			if(c.getCustomerUsername().equals(username) && c.getCustomerPassword().equals(password) && c.getCustomerId().toString().equals(customerId)) {
				checkUser = true;
				System.out.println("Username already exists. Please try again.");
				createAccount();
				break;
			}
			}
		
				//Create new Account
				if(!checkUser) {
			service.addNewCustomer(customerId, username, password);
			System.out.println("Congratulations you have created new account");
			MainLauncher.banking.info(username+" successfully created an account");
			Customer cus = new Customer();
			cus.setCustomerId(customerId);
			cus.setCustomerUsername(username);
			cus.setCustomerPassword(password);
			accountSetup(cus);
			
				}
		
	}
	
	
	//Account setup
	public static void accountSetup(Customer customer) {
		
		int accountChoice;
		int transaction;
		String  accountOwner = customer.getCustomerId();
		Double balance;
		String accountTypes="";
		
		Scanner scan = new Scanner(System.in);
		
		BankAccounts bc_acc = new BankAccounts();
		AccountTypes acc_Types = new AccountTypes();
		
		bc_acc.setAccountOwner(accountOwner);
		System.out.println("What type of account would you like to open?"
				+ "\n 1. Checking"
				+ "\n 2. Saving");
		accountChoice = scan.nextInt();
		switch(accountChoice) {
		
		case 1:
			accountTypes = "Checking";
			MainLauncher.banking.info("Opened checking account");
			bc_acc.setAccountTypeId(1);
			break;
			
		case 2:
			accountTypes = "Saving";
			MainLauncher.banking.info("Opened saving account");
			bc_acc.setAccountTypeId(2);
			break;
			
			default:
				System.out.println("Invalid option, try again.");
				accountSetup(customer);
				break;
			
		}
		
		System.out.println("How much would you like to deposit today?");
		balance = scan.nextDouble();
		
		bc_acc.setBalance(balance);
		MainLauncher.banking.info("Customer has deposited "+balance+" in bank.");

		
		
		//add info to bank
		
		bankService.saveBankAcc(bc_acc);
		System.out.println("You now have " + bc_acc.getBalance() + " in your account.");

		System.out.println("Would you like to: "
				+ "\n 1. Make another transaction"
				+ "\n 2. Create another account"
				+ "\n 3. Logout");
		
		transaction = scan.nextInt();
		
		switch (transaction) {
		
			case 1:
				welcomeBack(customer.getCustomerId());
				break;
			case 2:
				accountSetup(customer);
				break;
			case 3:
				System.out.println("I am logout");
				logout(customer.getCustomerId());
				break;
			default:
				System.out.println("Not a valid option");
				accountSetup(customer);
				break;
		
		
		}
		
		
		
		
		
		
		
	}
	
	//Welcome Back Screen
	public static void  welcomeBack(String id) {
		int choice;
		
		Scanner input = new Scanner(System.in);
		
		Customer currentCustomer = service.findCustomer(id);
		BankAccounts bk_acc = bankService.findBankAcc(id);
		
		System.out.println("Welcome back " + currentCustomer.getCustomerUsername() + "!"
				+ "\n Your current balance is: " +  bk_acc.getBalance()
				+ "\n Would you like to"
				+ "\n 1. Make a deposit"
				+ "\n 2. Make a withdrawal"
				+ "\n 3. Send money"
				+ "\n 4. Logout");
		
		choice = input.nextInt();
		
		switch(choice) {
		
		case 1:
			deposit(id);
			break;
		case 2:
			withdraw(id);
			break;
			
		case 3:
			transferMoney(id);
			break;
		case 4:
			logout(id);
			break;
		default:
			System.out.println("Not a valid choice");
			break;
	
	}
	
	
	
	}
	
	
	
	//Existing Customer Login
	public static void loginScreen() {
		
		String username;
		String password;
		boolean checkUser = false;
		System.out.println("Customer Login Screen");
		
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
		
		List<Customer> customer = service.findAllCustomer();
		
		for(Customer c : customer) {
			if(c.getCustomerUsername().equals(username) && c.getCustomerPassword().equals(password)) {
				checkUser = true;
				System.out.println("You have successfully logged in");
				MainLauncher.banking.info(c.getCustomerUsername()+" has logged in");

				welcomeBack(c.getCustomerId());
				break;
			}
		}
		
		if(!checkUser) {
			System.out.println("Username or Password is incorrect, please try again.");
			loginScreen();
		}

	}
	
	//Deposit money
	
	public static void deposit(String id) {
		double balance = 0;
		double deposit = 0;
		
		//Create a temporary account to grab current user info
			BankAccounts temp = null;
			
			Scanner input = new Scanner(System.in);
			
			//find account associated with id
			temp = bankService.findBankAcc(id);
			
			balance = temp.getBalance();
			System.out.println("Your current balance is "+balance);
			System.out.println("How much would you like to deposit?");
			deposit = input.nextDouble();
			
			if(deposit < 0) {
				System.out.println("Cannot deposit less than zero!");
				logout(id);
			}
			else {
			balance += deposit;
			}
			//intialize updateUser with accountType, accountOwner, and new balance	
			BankAccounts updateUser = new BankAccounts(temp.getAccountTypeId(),temp.getAccountOwner(), balance);
			
			bankService.updateBankAcc(updateUser);
			MainLauncher.banking.info("Customer has deposited "+ deposit+" to account "+temp.getAccountOwner());
			System.out.println("Your current balance is: " + updateUser.getBalance());
			
			logout(id);		

		
	}
	
	
	//withdraw money
	
	public static void withdraw(String id) {
	
		double balance = 0;
		double withdrawal = 0;
		
		//Create a temporary account to grab current user info
		BankAccounts temp = null;
		
		
		Scanner input = new Scanner(System.in);
		
		//find account associated with id
		temp = bankService.findBankAcc(id);
		
		balance = temp.getBalance();
		System.out.println("Your current balance is "+balance);

		System.out.println("How much would you like to withdraw?");
		withdrawal = input.nextDouble();
		//Make sure withdrawal is not greater than the current balance
				if (withdrawal > balance) {
					
					System.out.println("You do not have sufficient funds to continue!");
					logout(id);
					
				}
				else {
					
					balance -= withdrawal;

				}	

				BankAccounts updateUser = new BankAccounts(temp.getAccountTypeId(), temp.getAccountOwner(), balance);
				MainLauncher.banking.info("Customer has withdrawn "+ withdrawal+" from account "+temp.getAccountOwner() );

				bankService.updateBankAcc(updateUser);
				
				System.out.println("Your current balance is: " + updateUser.getBalance());
					
				logout(id);		
		
	}
	
	
	public static void transferMoney(String id) {
		
		double balance = 0;
		double sendMoney = 0;
		
		//Create a temporary account to grab current user info
				BankAccounts temp = null;
				BankAccounts temp1 = null;

				
				Scanner input = new Scanner(System.in);
				
				//find account associated with id
				temp = bankService.findBankAcc(id);
				
				balance = temp.getBalance();
				System.out.println("Your current balance is "+ balance);

				
				System.out.println("How much would you like to Transfer?");
				sendMoney = input.nextDouble();
				
				//Second account
				System.out.println("Select account Number to Transfer to?");
				input.nextLine();
				String accountNumber = input.nextLine();
				
				
				double secondAccountBalance = 0;


					
				//find account associated with id
				temp1 = bankService.findBankAcc(accountNumber);
				
				secondAccountBalance = temp1.getBalance();

				
				
				if (sendMoney > balance) {
					
					System.out.println("You do not have sufficient funds to continue!");
					logout(id);
					
				}else {
					balance -= sendMoney;
					
					
					BankAccounts updateUser = new BankAccounts(temp.getAccountTypeId(), temp.getAccountOwner(), balance);
					bankService.updateBankAcc(updateUser);
					
					
					secondAccountBalance += sendMoney;
					BankAccounts updateUser1 = new BankAccounts(temp1.getAccountTypeId(), temp1.getAccountOwner(), secondAccountBalance);
					bankService.updateBankAcc(updateUser1);
					Customer c = service.findCustomer(temp1.getAccountOwner());
					
					System.out.println("You have successfully transfered money to "+c.getCustomerUsername());
					System.out.println("Your current balance is: " + updateUser.getBalance());
						
					logout(id);	
					
				}
		
		
	}
	
	
	
	
	
	
	//Logout Menu
	public static void logout(String id) {

		Scanner input = new Scanner(System.in);
		
		int choice;
		
		System.out.println("Would you like to: "
				+ "\n 1. Logout"
				+ "\n 2. Complete another transaction?");
		
		
		choice = input.nextInt();
		
		switch (choice ) {
		
			case 1:
				System.out.println("Goodbye.");
				MainLauncher.banking.info("Customer has logged out");

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
				MainLauncher.start();
				break;
			
			case 2:
				welcomeBack(id);
				break;
			
			default:
				System.out.println("Not a valid choice");
				logout(id);
				break;
		
		}
		
		
	}
	
	
	
	
	
}
