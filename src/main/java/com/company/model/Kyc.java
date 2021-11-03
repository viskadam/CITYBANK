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
<<<<<<< HEAD
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

	

	
=======
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String ekyc;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="aid", referencedColumnName="aid")
	private Accounts acct;
	
	@Column(name="status")
	private int status;
	


	public String getEkyc() {
		return ekyc;
	}

	public void setEkyc(String ekyc) {
		this.ekyc = ekyc;
	}

	public Accounts getAcct() {
		return acct;
	}

	public void setAcct(Accounts acct) {
		this.acct = acct;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5


}
