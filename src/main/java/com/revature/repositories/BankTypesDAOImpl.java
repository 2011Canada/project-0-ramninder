package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.AccountTypes;
import com.revature.util.ConnectionFactory;

public class BankTypesDAOImpl implements BankTypesDAO {
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();

	@Override
	public AccountTypes save(AccountTypes obj) {
		
		try {
			Connection conn = cf.getConnection();
			
			String sql = "INSERT INTO \"BK_ACCOUNT_TYPES\" (\"ACC_TYPE\") VALUES(?)\n"
					+"";
			String[] keyNames = {"TYPE_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keyNames);
			ps.setString(1, obj.getAccountType());
			
			int numRows = ps.executeUpdate();
			
			System.out.println(obj.getAccountType());
			if(numRows > 0) {
				
				ResultSet rs = ps.getGeneratedKeys();
				
				while(rs.next()) {
					
					obj.setId(rs.getString(1));
					
				}
				
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return obj;	
	}
	
	

}
