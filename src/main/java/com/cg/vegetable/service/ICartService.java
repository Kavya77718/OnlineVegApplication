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

	public Cart addCartToCustomer(int custId);

	public void addProduct(Vegetable dto, int customerId);

	public Vegetable UpdateVegQuantity(int vegId, int quantity);

	public Cart deleteById(int cartId);

	public List<Vegetable> getProductsInCart(int custId);

	public Cart getTotalcost(int custId);

	public int totalQuantity(int custId);

	public List<Vegetable> removeProduct(Vegetable product, int custId);


}