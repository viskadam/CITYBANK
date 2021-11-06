package com.company.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "kyc")
public class Kyc implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ekyc;
	
	@Column
	private String accnum;
	
	@Column(name="Delete_flag")
	private String flag="N";
	
	public String getAccnum() {
		return accnum;
	}

	public void setAccnum(String accnum) {
		this.accnum = accnum;
	}

	@Column(length=500)
	private String doc;
	


	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public Long getEkyc() {
		return ekyc;
	}

	public void setEkyc(Long ekyc) {
		this.ekyc = ekyc;
	}

	

	


}
