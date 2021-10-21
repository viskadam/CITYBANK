package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.company.model.Customer;


@Repository
public interface CustRepository extends JpaRepository<Customer, Long> {
	 
    public Customer findByUsername(String username);
    
    public Customer findByUsernameAndPassword(String username,String password);
    
   @Query("SELECT u FROM Customer u WHERE u.email = ?1")
   public  Customer findByEmail(String email);
   
   @Transactional
   @Modifying
   @Query("update Customer c set c.password = :password where c.email = :email")
   void updatePassword(@Param("email") String email, @Param("password") String password);
   
   @Query(value="select c.email from Customer c where email= :email",nativeQuery=true)
   String findByEmailAddress(String email);
	
}