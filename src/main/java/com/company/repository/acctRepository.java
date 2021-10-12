package com.company.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.model.Accounts;


@Repository
public interface acctRepository extends CrudRepository<Accounts, Long> {
	 
	 
	 
	
}