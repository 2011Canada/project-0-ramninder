package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.BankAccounts;
import com.revature.models.Customer;
import com.revature.util.ConnectionFactory;

public class BankAccountsDAOImpl implements BankAccountDAO {
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();


	@Override
	public BankAccounts save(BankAccounts obj) {
		// TODO -generated method stub
		try {
	Connection conn = cf.getConnection();
	
	String sql = "INSERT INTO \"BK_ACCOUNTS\"(\"ACC_TYPE_ID\", \"ACC_OWNER\", \"ACC_BALANCE\") VALUES(?, ?, ?);\n"
			+ "";
	String[] keyNames = {"ACC_ID"};
	PreparedStatement ps = conn.prepareStatement(sql, keyNames);
	ps.setInt(1, obj.getAccountTypeId());
	ps.setString(2, obj.getAccountOwner());
	ps.setDouble(3, obj.getBalance());
	 
	int numRows = ps.executeUpdate();
	
	if(numRows == 1) {
		
		ResultSet rs = ps.getGeneratedKeys();
		
		while(rs.next()) {
			
			obj.setId(rs.getString(1));
			
		}}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	return obj;	
	}


	@Override
	public BankAccounts findById(String id) {
		
		BankAccounts  bk = null;
		
		try {
			Connection conn = cf.getConnection();
			String sql = "select * from \"BK_ACCOUNTS\" where \"ACC_OWNER\" = ? "
					+ "";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				bk = new BankAccounts();
				bk.setId(rs.getString(1));
				bk.setAccountTypeId(rs.getInt(2));
				bk.setAccountOwner(rs.getString(3));
				bk.setBalance(rs.getDouble(4));
				
			}


		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return bk ;
	}


	@Override
	public BankAccounts update(BankAccounts obj) {
		try {
			Connection conn = cf.getConnection();
			String sql = "UPDATE \"BK_ACCOUNTS\" SET \"ACC_BALANCE\" = ? WHERE \"ACC_TYPE_ID\" = ? AND \"ACC_OWNER\" = ?\n"
					+ "";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDouble(1,  obj.getBalance());
			ps.setInt(2, obj.getAccountTypeId());
			ps.setString(3, obj.getAccountOwner());
			ps.executeUpdate();

			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return obj;
	}


	@Override
	public List<BankAccounts> findAll() {
		List<BankAccounts> bank_acc = new ArrayList<BankAccounts>();
		
		try {
			Connection conn = cf.getConnection();
			
			String sql = "SELECT * FROM \"BK_ACCOUNTS\" ORDER BY \"ACC_OWNER\"\n"
					+ "";
			
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				BankAccounts acc = new BankAccounts();
				acc.setId(String.valueOf(rs.getInt("ACC_ID")));
				acc.setAccountTypeId(rs.getInt(2));
				acc.setAccountOwner(rs.getString(3));
				acc.setBalance(rs.getDouble(4));
				bank_acc.add(acc);


			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bank_acc;

	}


	@Override
	public BankAccounts delete(String id) {
		
		try {
			Connection conn = cf.getConnection();
			String sql = 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
