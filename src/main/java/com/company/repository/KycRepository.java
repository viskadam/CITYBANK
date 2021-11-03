package com.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.company.model.Kyc;


@Repository

public interface KycRepository extends CrudRepository<Kyc, Long> {
	@Modifying
	@Query("update Kyc set flag='Y' where ekyc = :id")
	public void updateEkyc(@Param("id")Long id);
	
	@Query("select u from Kyc u where u.flag = 'N'")
	public Iterable<Kyc> getKyc();
	
	
}
