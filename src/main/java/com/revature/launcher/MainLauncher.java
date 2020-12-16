package com.revature.launcher;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.menu.CustomerMenu;
import com.revature.menu.EmployeeMenu;

public class MainLauncher {
	
	
	public static Logger banking = LogManager.getLogger("com.revature.bank");
	
	
	public static void main(String []args) {
		
		
		//CustomerMenu.createAccount();
		//CustomerMenu.transferMoney("520");
		//CustomerMenu.logout("520");
		
		banking.info("Server has Started");
		
		start();
		
		

	}
	
	public static void start() {
		
		Scanner input  = new Scanner(System.in);
		System.out.println("Welcome to The Bank"+
				"\n 1. Customer "+"\n 2. Employee ");
		
		int choice = input.nextInt();
		
		switch(choice) {
		
		case 1:
		CustomerMenu.customerEntry();
		break;	
		
		case 2:
		EmployeeMenu.loginScreen();	
		break;
		
		
		default:
		System.out.println("Not a valid choice");
		start();	
		break;
		
	}
		
		
	}


}
