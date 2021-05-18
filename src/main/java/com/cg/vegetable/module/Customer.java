package com.cg.vegetable.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Customer {
	@Id
	private int customerId;
	private String name;
	@NotEmpty(message = "Please enter your mobile number to proceed")
	private String mobileNumber;
	@Email
	private String emailId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Address_id", referencedColumnName = "id")
	private Address address;
		
	public Customer(int customerId, String name, String mobileNumber, String emailId) {
		this.customerId = customerId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
	}

	public Customer() {
	}
	
	public Customer(int customerId) {
		this.customerId = customerId;
	}
	
	public Customer(Address address) {
		this.address = address;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", mobileNumber=" + mobileNumber + ", emailId="
				+ emailId + ", address=" + address + "]";
	}
	
}

