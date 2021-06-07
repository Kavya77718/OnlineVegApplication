package com.cg.vegetable.module;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * CartEntity class
 *
 */
@Entity
public class Cart {
	/**
	 * creating instance variables for the class CartEntity
	 */
	@Id
	private int cartId;
	/**
	 * CustomerEntity is mapped to CartEntity
	 * 
	 */
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "custId")
	private Customer customer;
	/**
	 * CartEntity is mapped to VegetableEntity
	 */

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "veg_Id", referencedColumnName = "vegId")
	private List<Vegetable> vegetables;

	/**
	 * Creating Constructor
	 */

	public Cart() {
	}

	public Cart(int cartId) {
		super();
		this.cartId = cartId;

	}

	/**
	 * *Getter&Setters
	 */

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Vegetable> getVegetables() {
		return vegetables;
	}

	public void setVegetables(List<Vegetable> vegetables) {
		this.vegetables = vegetables;
	}

	/**
	 * Creating ToString Method
	 */
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", vegetables=" + vegetables + ", customer=" + customer + "]";
	}

}
