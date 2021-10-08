package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.model.Accounts;



public interface acctRepository extends JpaRepository<Accounts, Long> {
	 
	 //Accounts findAccountNum(String acct);
	 
	
}