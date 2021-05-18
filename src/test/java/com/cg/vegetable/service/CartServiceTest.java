package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vegetable.module.Cart;

@SpringBootTest
class CartServiceTest {

	@Autowired
	ICartService ic;
	
	@Test
	void testaddToCart() {
		Cart cart = new Cart(3);
		Cart persistedCust = ic.addToCart(cart);
		assertEquals(3,persistedCust.getCartId());
		
	}
	@Test
	void testviewAllItems() {
		List<Cart> cart1=ic.viewAllItems();
		assertEquals(2, cart1.size());
		
	}
	
	@Test
	void testremoveAllItems () {
	    ic.removeAllItems();
		//assertEquals(1, cart2.size());
	}
	
}

