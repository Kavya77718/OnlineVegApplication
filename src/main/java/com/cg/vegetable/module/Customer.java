package com.cg.vegetable.module;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Customer Entity
 */

@Entity
public class Customer {
	
	/**
	 * Creating instance variable for the class Customer Entity
	 */
	@Id
	private int customerId;
	@NotEmpty(message = "Please enter your name to proceed")
	private String name;
	@NotEmpty(message = "Please enter your mobile number to proceed")
	@Size(min=10 , max=10, message = "Invalid mobileNumber")
	private String mobileNumber;
	@NotEmpty(message = "Please enter your email Id to proceed")
	@Email(message = "Invalid Email")
	private String emailId;
	
	/**
	 * CustomerEntity is mapped to AddressEntity
	 */
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="cust_id")
	private List<Address> address;
	
	/**
	 * Creating no arg constructor.
	 */
	public Customer() {
	}
	
	/**
	 * Creating arg constructor.
	 */
	public Customer(int customerId, String name, String mobileNumber, String emailId) {
		this.customerId = customerId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
	}
	
	public Customer(int customerId) {
		this.customerId = customerId;
	}

	public Customer(Address address) {
		this.address = (List<Address>) address;
	}

	/**
	 * getters and setters
	 */
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

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address2) {
		this.address = address2;
	}

	/**
	 * Creating toString
	 */
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", mobileNumber=" + mobileNumber + ", emailId="
				+ emailId + ", address=" + address + "]";
	}

	
}


}
