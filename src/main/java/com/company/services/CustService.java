package com.company.services;

import java.util.List;
import java.util.Optional;

import com.company.constants.Roles;

import com.company.model.Accounts;

import com.company.model.Customer;
import com.company.model.Kyc;

public interface CustService {
	void save(Customer cust,Roles role, Accounts acc,Kyc kyc);

	public Customer findByUsername(String username);

	void deleteCust(long id);
	
	

	public List<Customer> getCust();
	
	public Iterable<Kyc> getKyc();
	
	void deleterec(Long ekyc);
	
	
	  public Customer findByEmail(String email);
	
	
	
}