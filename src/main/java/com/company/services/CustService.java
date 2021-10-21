package com.company.services;

import java.util.List;

import com.company.constants.Roles;
import com.company.model.Accounts;

import com.company.model.Customer;
import com.company.model.Kyc;

public interface CustService {
	void save(Customer cust,Roles role, Accounts acc);

	public Customer findByUsername(String username);

	void deleteCust(long id);

	public List<Customer> getCust();
	
	  public Customer findByEmail(String email);
	
	
	
}