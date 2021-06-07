package com.cg.vegetable.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vegetable.module.Cart;
import com.cg.vegetable.module.Vegetable;
import com.cg.vegetable.service.ICartService;
import com.cg.vegetable.service.VegetableServiceImpl;

@RestController
public class CartController {
	/**
	 * Logger
	 */

	org.apache.logging.log4j.Logger logger = LogManager.getLogger(VegetableServiceImpl.class);

	/**
	 * AutoWiring the service class to call down the service
	 */
	@Autowired
	ICartService vgs;

	/**
	 * This below function is used to create a new cart and redirects to the cart
	 * service
	 */

	@PostMapping("/cart")
	public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
		logger.info("Successfully Added" + cart);
		vgs.addToCart(cart);
		return ResponseEntity.ok(cart);
	}

	/**
	 * This below function is used to view All items and redirects to the cart
	 * service
	 */

	@GetMapping("/cart/viewAllItems")
	public ResponseEntity<List<Cart>> viewAllItems() {
		logger.info("Viewed Successfully");
		List<Cart> cart = vgs.viewAllItems();
		return ResponseEntity.ok(cart);
	}

	/**
	 * This below function is used to remove All items based on the given vegId and
	 * redirects to the cart service
	 */

	@DeleteMapping("/cart/remove")
	public void removeAllItems() {
		logger.info("Removed Successfully");
		vgs.removeAllItems();

	}

	/**
	 * This below function is used to update a cart based on the given vegId and
	 * redirects to the Cart service
	 */

	@PatchMapping("/cart/update")
	public ResponseEntity<Vegetable> UpdateVegQuantity(int vegId, int quantity) {
		logger.info("Successfully Updated" + vegId, quantity);
		Vegetable vegetable = vgs.UpdateVegQuantity(vegId, quantity);
		return ResponseEntity.ok(vegetable);
	}

}
