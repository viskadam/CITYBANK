package com.company.repository;

<<<<<<< HEAD
import java.util.List;

=======
<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
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
    
<<<<<<< HEAD
   @Query("SELECT u FROM Customer u WHERE u.email = 'devanshimadhani20@gmail.com'")
   public  List<Customer> findByEmail(String email);
=======
<<<<<<< HEAD
   @Query("SELECT u FROM Customer u WHERE u.email = 'devanshimadhani20@gmail.com'")
   public  List<Customer> findByEmail(String email);
=======
   @Query("SELECT u FROM Customer u WHERE u.email = ?1")
   public  Customer findByEmail(String email);
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
   
   @Transactional
   @Modifying
   @Query("update Customer c set c.password = :password where c.email = :email")
   void updatePassword(@Param("email") String email, @Param("password") String password);
   
<<<<<<< HEAD
   @Query(value="select c.email from Customer c where c.email= :email")
=======
<<<<<<< HEAD
   @Query(value="select c.email from Customer c where c.email= :email")
=======
   @Query(value="select c.email from Customer c where email= :email",nativeQuery=true)
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
   String findByEmailAddress(String email);
	
}