package com.cg.vegetable.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vegetable.exception.CartNotFoundException;
import com.cg.vegetable.module.Cart;
import com.cg.vegetable.module.Vegetable;
import com.cg.vegetable.repository.IVegetableRepository;
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
	ICartService cartser;

	@Autowired
	IVegetableRepository vegRepo;
	

	/**
	 * This below function is used to create a new cart and redirects to the cart
	 * service
	 */

	@PostMapping("/cart")
	public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
		logger.info("Successfully Added" + cart);
		cartser.addToCart(cart);
		return ResponseEntity.ok(cart);
	}

	/**
	 * This below function is used to view All items and redirects to the cart
	 * service
	 */

	@GetMapping("/cart/viewAllItems")
	public ResponseEntity<List<Cart>> viewAllItems() {
		logger.info("Viewed Successfully");
		List<Cart> cart = cartser.viewAllItems();
		return ResponseEntity.ok(cart);
	}

	/**
	 * This below function is used to remove All items based on the given vegId and
	 * redirects to the cart service
	 */

	@DeleteMapping("/cart/remove")
	public void removeAllItems() {
		logger.info("Removed Successfully");
		cartser.removeAllItems();

	}

	/**
	 * This below function is used to update a cart based on the given vegId and
	 * redirects to the Cart service
	 */

	@PatchMapping("/cart/update")
	public ResponseEntity<Vegetable> UpdateVegQuantity(int vegId, int quantity) {
		logger.info("Successfully Updated" + vegId, quantity);
		Vegetable vegetable = cartser.UpdateVegQuantity(vegId, quantity);
		return ResponseEntity.ok(vegetable);
	}

	@DeleteMapping("/cart/{id}")
	public ResponseEntity<Cart> deleteCartById(@PathVariable("id") int cartId) {
		logger.info("Deleting the cart by id");
		Cart car = cartser.deleteById(cartId);
		if (car == null) {
			throw new CartNotFoundException("Cart  not found with this id to delete" + cartId);
		}
		return ResponseEntity.ok(car);
	}

	@PostMapping("/addcarttocustomer/{id}")
	public ResponseEntity<Cart> addCartToCustomer(@PathVariable("id") int custId) {
		logger.info("Adding cart to a customer");
		Cart cart = cartser.addCartToCustomer(custId);
		return ResponseEntity.ok(cart);
	}

	@PostMapping("/shoppingCart/addProduct/{vegId}/{custId}")
	public String addVegToCart(@PathVariable("vegId") int vegId, @PathVariable("custId") int customerId) {
		logger.info("Adding products to the cart");
		Optional<Vegetable> veg = vegRepo.findById(vegId);
		if (veg.isPresent()) {
			cartser.addProduct(veg.get(), customerId);
			return "added to cart";
		}
		return "out of stock";
	}

	@GetMapping("/getproducts/cart/{custId}")
	public List<Vegetable> getProductsFromCart(@PathVariable("custId") int custId) {
		logger.info("Getting products in the cart");
		return cartser.getProductsInCart(custId);

	}
	
	@DeleteMapping("/removecartitem/{productId}/{custId}")
	public List<Vegetable> removeproductfromCart(@PathVariable("productId") int productId, @PathVariable("custId") int custId) {
		logger.info("Removing products from the cart");
		Optional<Vegetable> med = vegRepo.findById(productId);
		if (med.isPresent()) {
			cartser.removeProduct(med.get(), custId);
		}
		return cartser.getProductsInCart(custId);
	}

	@GetMapping("/gettotal/cart/{custId}")
	public Cart gettotalCost(@PathVariable("custId") int custId) {
		return cartser.getTotalcost(custId);
	}
	@GetMapping("/getquantity/cart/{custId}")
	public int getQuantity(@PathVariable("custId") int custId) {
		logger.info("Getting quantity in the cart");
		return cartser.totalQuantity(custId);

	}

}