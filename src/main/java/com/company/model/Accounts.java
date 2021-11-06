package com.company.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
@Entity
@Table(name = "Accounts")
@NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a")
public class Accounts implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aid;
	@Column(length = 25)
	private String accountnumber;
	@Column(name = "balance", precision = (2))
	private double balance;

	@Column(length = 25,name="KYC_FLAG")
	private String kycFlag = "PEND";

	public Accounts() {

	}

	
	public String getKycFlag() {
		return kycFlag;
	}

	public void setKycFlag(String kycFlag) {
		this.kycFlag = kycFlag;
	}

	

	public String getAccountnumber() {
		return this.accountnumber;
	}

	@Column(length = 25)
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber + (long) (Math.round(Math.random() * 25000));
<<<<<<< HEAD
=======
=======


@Entity
@Table(name = "Accounts")
@NamedQuery(name="Accounts.findAll", query="SELECT a FROM Accounts a")
public class Accounts implements Serializable {
	

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long aid;
	@Column(length=25)
	private String accountnumber;
	@Column(name="balance",precision=(2))
	private double balance;
	
	
	

	public Accounts() {
		 
	}
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Acc_id",referencedColumnName="aid")
	private Set<Customer> customer;
	
	
	public Set<Customer> getCustomer() {
		return customer;
	}
	
	
	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}
	
	
	public String getAccountnumber() {
		return this.accountnumber ;
	}
	@Column(length=25)
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber+(long)(Math.round(Math.random()*25000));
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
	}

	public Long getAid() {
		return this.aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public double getBalance() {
		return this.balance;
	}
<<<<<<< HEAD

	@Column(length = 25)
=======
<<<<<<< HEAD

	@Column(length = 25)
=======
	@Column(length=25)
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
	public void setBalance(double balance) {
		this.balance = balance;
	}

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
	
	
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
}