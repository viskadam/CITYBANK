package com.company.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.company.model.Accounts;



public interface acctRepository extends JpaRepository<Accounts, Long> {
	 
	  //Accounts findAccountNum(String accno);
//	List<Accounts> findByAccountNumber(String accountnumber);
//	
//	@Query("select a from Accounts a where a.accountnumber = :accountnumber ")
//	Stream<Accounts> findByAccountNumberReturnStream(@Param("accountnumber") String accountnumber);
//
//	Accounts findAccountNum(String accountnumber);
//	
}