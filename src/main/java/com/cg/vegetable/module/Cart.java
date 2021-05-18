package com.cg.vegetable.module;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity

public class Cart {
	@Id
	private int cartId;

	
	/*@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="vegId", referencedColumnName = "vegId")
	private List<Vegetable> vegetables;
	*/
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="veg_Id", referencedColumnName = "vegId")
	private List<Vegetable> vegetables;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "custId")
	private Customer customer;

	private int custId;


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cartId")
	private List<Vegetable> vegetables;
	
	public Cart() {

	}


	public Cart(int cartId) {
		super();
		this.cartId = cartId;
	}

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

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", vegetables=" + vegetables + ", customer="
				+ customer + "]";
	}

