package com.revature.service;

import java.util.List;

import com.revature.models.BankAccounts;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.repositories.BankAccountDAO;
import com.revature.repositories.BankAccountsDAOImpl;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.EmployeeDAOImpl;

public class EmployeeSrevice {
	 Employee employee = new Employee();;
	 
	static  EmployeeDAO empData = new EmployeeDAOImpl();
	
	static BankAccountDAO bankAcc = new BankAccountsDAOImpl();

	
public List<BankAccounts> findAllBankAcc() {
		
		return bankAcc.findAll();
		
	}
	
	
	public Employee addNewEmployee(String id, String username, String password) {
		
		employee.setId(id);
		employee.setUsername(username);
		employee.setPassword(password);
		
		return empData.addNewEmployee(employee);
		
	}

	
	public List<Employee> findAllEmployee() {
		return empData.findAllEmployee();
	}


}
