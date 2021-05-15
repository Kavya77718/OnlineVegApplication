package com.cg.vegetable.module;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity

public class Cart {
	@Id
	private int cartId;
	private int custId;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="cartId")
	private List<Vegetable> vegetables;

	public Cart() {

	}

	public Cart(int cartId, int custId) {
		super();
		this.cartId = cartId;
		this.custId = custId;
		

	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public List<Vegetable> getVegetables() {
		return vegetables;
	}

	public void setVegetables(List<Vegetable> vegetables) {
		this.vegetables = vegetables;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", custId=" + custId + ", vegetables=" + vegetables + "]";
	}

	
	

}
