package com.cg.vegetable.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.vegetable.module.Cart;
import com.cg.vegetable.module.Vegetable;

@Service
public interface ICartService {

	public Cart addToCart(Cart cart);

	public List<Cart> viewAllItems();

	public void removeAllItems();
	
	public Vegetable UpdateVegQuantity(int vegId, int quantity);

}
