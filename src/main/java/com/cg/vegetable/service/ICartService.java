package com.cg.vegetable.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.vegetable.module.Cart;


@Service
public interface ICartService {

	public Cart addToCart(Cart cart);
	public List<Cart> viewAllItems();
	public void removeAllItems();
	/*public Cart calculateVegPriceBasedOnCustomerCartVegQuantity(int vegId, int customerId, int cartId, int quantity);*/
	

}
