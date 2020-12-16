package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.util.ConnectionFactory;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();

	public Employee addNewEmployee(Employee obj) {
		
		try {
			Connection conn = cf.getConnection();
			
			String sql = "insert into \"Employee\" (\"id\", \"username\", \"password\") "
					+ "values( ?, ?, ? );\n";
			
			PreparedStatement insertEmployee = conn.prepareStatement(sql);
			
			 insertEmployee.setString(1, obj.getId());
			 insertEmployee.setString(2, obj.getUsername());
			 insertEmployee.setString(3, obj.getPassword());
			 			 
			 	if(insertEmployee.executeUpdate() != 0) {
			 		
			 		System.out.println("Created new Customer");
			 					 	}
			 	else {
			 		System.out.println("There was error inserting record");
			 	}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return obj;
	}

	public List<Employee> findAllEmployee() {
		List<Employee> cust = new ArrayList<>();
		
		try {
			Connection conn = cf.getConnection();
			
			String sql = "select * from \"Employee\";\n"
					+ "";
				Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			
		while(res.next()) {
			
			String id=res.getString("id");
			String username=res.getString("username");
			String password=res.getString("password");

			Employee emp  = new Employee();
			
			emp.setId(id);
			emp.setUsername(username);
			emp.setPassword(password);
			cust.add(emp);
		}	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return cust;
	}

	


	

}
