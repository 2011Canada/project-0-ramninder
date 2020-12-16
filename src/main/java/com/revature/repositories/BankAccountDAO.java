package com.revature.repositories;

import java.util.List;

import com.revature.models.BankAccounts;

public interface BankAccountDAO {
	
	
	public BankAccounts save(BankAccounts obj);
	
	public BankAccounts findById(String id);
	
	public BankAccounts update(BankAccounts obj);
	
	public List<BankAccounts> findAll();
	
	public String delete(String id);

}
