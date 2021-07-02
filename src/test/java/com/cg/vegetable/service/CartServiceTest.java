package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vegetable.module.Cart;

@SpringBootTest
class CartServiceTest {

	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(CartServiceTest.class);

	/**
	 * AutoWiring the service class to call down the service Test to
	 */
	@Autowired
	ICartService ic;

	/**
	 * This below function is used to Test the method AddtoCart and redirects to the
	 * cart service
	 */
	@Test
	@Disabled
	void testaddToCart() {
		Cart cart = new Cart(3,1);
		Cart persistedCust = ic.addToCart(cart);
		assertEquals(3, persistedCust.getCartId());
		logger.info("Added to the cart successfully" + cart);

	}

	/**
	 * This below function is used to Test the method ViewAllItems and redirects to
	 * the cart service
	 */
	@Test
	@Disabled
	void testviewAllItems() {
		List<Cart> cart1 = ic.viewAllItems();
		assertEquals(2, cart1.size());
		logger.info("Viewed All Items successfully");
	}

	/**
	 * This below function is used to Test the method removeAllItems and redirects
	 * to the cart service
	 */

	@Test
	void testremoveAllItems() {
		ic.removeAllItems();
		logger.info("Removed All Items successfully");
	}

}
