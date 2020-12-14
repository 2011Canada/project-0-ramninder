package com.revature.repositories;

import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Employee;

public interface EmployeeDAO {
	
	public Employee addNewEmployee(Employee obj);
	
	public List<Employee> findAllEmployee();
	
	

}
