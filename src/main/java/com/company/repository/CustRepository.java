package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.company.model.Customer;



public interface CustRepository extends JpaRepository<Customer, Long> {
	 
    Customer findByUsername(String username);
	 
	
}