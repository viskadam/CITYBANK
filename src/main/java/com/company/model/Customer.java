
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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")

<<<<<<< HEAD
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
public class Customer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", length = 25)
	private String name;

	@Column(name = "mobile", length = 100)
	private String mobile;

	@Column(nullable = false, unique = true, length = 45)
	private String email;

	@Column(name = "address", length = 25)
	private String address;

	@Column(name = "username", length = 100)
	private String username;

	@Column(name = "password", length = 150)
	private String password;

	@Column(name= "acc_id", length = 200)
	public String accountNumber;
	
	
	
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

=======
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id")
	private Long id;
	
	@Column(name = "name",length=25)
	private String name;
	
	 @Column(name = "mobile",length=100)
	private String mobile;
	 
	@Column(nullable = false, unique = true, length = 45)
	private String email;
	 
	 @Column(name = "address",length=25)
	private String address;
	
	
	 
	 @Column(name = "username",length=25)
	private String username;

	 @Column(name = "password",length=150)
	private String password;
	 
	
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
	public Set<BankRole> getBankRoles() {
		return bankRoles;
	}

	public void setBankRoles(Set<BankRole> bankRoles) {
		this.bankRoles = bankRoles;
	}

	@OneToMany
<<<<<<< HEAD
	private Set<BankRole> bankRoles;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ekyc", referencedColumnName = "ekyc")
=======
		private Set<BankRole> bankRoles;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ekyc", referencedColumnName="ekyc")
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
	private Kyc kyc;

	public Kyc getKyc() {
		return kyc;
	}

	public void setKyc(Kyc kyc) {
		this.kyc = kyc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

<<<<<<< HEAD
	public void setEmail(String email) {
=======
	public void  setEmail(String email) {
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

<<<<<<< HEAD
=======
	

>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
<<<<<<< HEAD

=======
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
	public Set<BankRole> getRoles() {
		return bankRoles;
	}

	public void setRoles(Set<BankRole> bankRoles) {
		this.bankRoles = bankRoles;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", address="
				+ address + ", username=" + username + ", bankRoles=" + bankRoles + "]";
	}
<<<<<<< HEAD
=======
	

>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5

}