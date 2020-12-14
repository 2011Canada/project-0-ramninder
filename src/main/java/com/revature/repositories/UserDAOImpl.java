package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.util.ConnectionFactory;

public class UserDAOImpl implements UserDAO {

	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();

		

		@Override
		public Customer addNewUser(Customer obj) {
			try {
			Connection conn = cf.getConnection();
			
			String sql = "insert into \"Customer\" (\"id\", \"username\", \"password\") "
					+ "values( ?, ?, ? );\n";
			
			PreparedStatement insertCustomer = conn.prepareStatement(sql);
			
			 insertCustomer.setString(1, obj.getCustomerId());
			 insertCustomer.setString(2, obj.getCustomerUsername());
			 insertCustomer.setString(3, obj.getCustomerPassword());
			 			 
			 	if(insertCustomer.executeUpdate() != 0) {
			 		
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



		@Override
		public List<Customer> findAllCustomer() {
			List<Customer> cust = new ArrayList<>();
			
			try {
				Connection conn = cf.getConnection();
				
				String sql = "select * from \"Customer\";\n"
						+ "";
					Statement stmt = conn.createStatement();
				ResultSet res = stmt.executeQuery(sql);
				
			while(res.next()) {
				
				String id=res.getString("id");
				String username=res.getString("username");
				String password=res.getString("password");

				Customer cus  = new Customer();
				
				cus.setCustomerId(id);
				cus.setCustomerUsername(username);
				cus.setCustomerPassword(password);
				cust.add(cus);
			}	
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return cust;
		}



		@Override
		public Customer findCustomerById(String id) {
			
			Customer customer = null;
			
			try {
				Connection conn = cf.getConnection();
				String sql = "select * from \"Customer\" where \"id\" = ? "
						+ "";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					customer = new Customer();
					customer.setCustomerId(rs.getString(1));
					customer.setCustomerUsername(rs.getString(2));
					customer.setCustomerPassword(rs.getString(3));
					
				}


			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return customer;
			
		}
		
		
		



		
	
	
}
