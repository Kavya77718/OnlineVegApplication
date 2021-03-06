package com.cg.vegetable.module;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Customer Entity
 */

@Entity
public class Customer {
	
	/**
	 * Creating instance variable for the class Customer Entity
	 */
	@Id
	@GeneratedValue
	private int customerId;
	@NotEmpty(message = "Please enter your name to proceed")
	private String name;
	@NotEmpty(message = "Please enter your mobile number to proceed")
	@Size(min=10 , max=10, message = "Invalid mobileNumber")
	private String mobileNumber;
	@NotEmpty(message = "Please enter your email Id to proceed")
	@Email(message = "Invalid Email")
	private String emailId;
    @Size(min=8, max=10, message = "invalid password")
	private String customerPassword;
	/**
	 * CustomerEntity is mapped to AddressEntity
	 */
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="cust_id")
	private List<Address> address;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_Id", referencedColumnName = "cartId")
	private Cart cart;
	/**
	 * Creating no arg constructor.
	 */
	public Customer() {
	}
	
	/**
	 * Creating arg constructor.
	 * @param customerPassword 
	 */
	public Customer(String name, String mobileNumber, String emailId, String customerPassword) {
	
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.customerPassword=customerPassword;
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

	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	/**
	 * Creating toString
	 */
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", mobileNumber=" + mobileNumber + ", emailId="
				+ emailId + ", customerPassword=" + customerPassword + ", address=" + address + ", cart=" + cart + "]";
	}

	
}