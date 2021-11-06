package com.company.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
<<<<<<< HEAD
=======
=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6

import com.company.model.Accounts;



public interface acctRepository extends JpaRepository<Accounts, Long> {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
	@Query("select c.kycFlag from Accounts c where c.accountnumber = :aid")
	public String getKycFlag(@Param("aid")String accountNumber);
	
	 @Transactional
	  @Modifying
	@Query("update Accounts set kycFlag = 'UPLD' where accountnumber= :aid")
	public void updFlag(@Param("aid")String accountNumber);
	 
<<<<<<< HEAD
=======
=======
	 
	  //Accounts findAccountNum(String accno);
//	List<Accounts> findByAccountNumber(String accountnumber);
//	
//	@Query("select a from Accounts a where a.accountnumber = :accountnumber ")
//	Stream<Accounts> findByAccountNumberReturnStream(@Param("accountnumber") String accountnumber);
//
//	Accounts findAccountNum(String accountnumber);
//	
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
}