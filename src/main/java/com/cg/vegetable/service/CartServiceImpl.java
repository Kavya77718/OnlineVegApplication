package com.cg.vegetable.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vegetable.module.Cart;
import com.cg.vegetable.module.Vegetable;
import com.cg.vegetable.repository.ICartRepository;
import com.cg.vegetable.repository.IVegetableRepository;

@Service
public class CartServiceImpl implements ICartService {
	/**
	 * Logger
	 */

	org.apache.logging.log4j.Logger logger = LogManager.getLogger(CartServiceImpl.class);

	/**
	 * AutoWiring the repository class to call down the service
	 */

	@Autowired
	ICartRepository crtRepo;

	/**
	 * AutoWiring the repository class to call down the service
	 */

	@Autowired
	IVegetableRepository vegrepo;

	/**
	 * This below function is used to create a new cart and redirects to the cart
	 * repository
	 */
	@Override
	public Cart addToCart(Cart cart) {
		logger.info("Added to the cart successfully" + cart);
		return crtRepo.save(cart);
	}

	/**
	 * This below function is used to get all cart and redirects to the cart
	 * repository
	 */
	@Override
	public List<Cart> viewAllItems() {
		logger.info("Viewed AllItems");
		return crtRepo.findAll();
	}

	/**
	 * This below function is used to remove All items based on the given vegId and
	 * redirects to the cart repository
	 */

	@Override
	public void removeAllItems() {
		logger.info("Removed All Items");
		crtRepo.deleteAll();
	}

	/**
	 * This below function is used to update a specific vegetable based on the given
	 * vegId and redirects to the vegetable repository
	 */

	@Override
	public Vegetable UpdateVegQuantity(int vegId, int quantity) {
		Optional<Vegetable> vegetable = vegrepo.findById(vegId);
		if (!vegetable.isPresent()) {
			return null;
		}
		Vegetable veg = vegetable.get();
		veg.getQuantity();
		veg.setQuantity(quantity);
		logger.info("Updated Successfully" + veg);
		return vegrepo.save(veg);
	}

}