package com.company.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.company.model.Accounts;



public interface acctRepository extends JpaRepository<Accounts, Long> {
	@Query("select c.kycFlag from Accounts c where c.accountnumber = :aid")
	public String getKycFlag(@Param("aid")String accountNumber);
	
	 @Transactional
	  @Modifying
	@Query("update Accounts set kycFlag = 'UPLD' where accountnumber= :aid")
	public void updFlag(@Param("aid")String accountNumber);
	 
}