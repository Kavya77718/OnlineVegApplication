package com.cg.vegetable.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vegetable.module.Cart;
import com.cg.vegetable.module.Customer;
import com.cg.vegetable.module.Vegetable;
import com.cg.vegetable.repository.ICartRepository;
import com.cg.vegetable.repository.ICustomerRepository;
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

	
	@Autowired
	ICustomerRepository custRepo;

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
	 * This below function is used to remove All items based on the given vegId and
	 * redirects to the cart repository
	 */
	@Override
	public Cart deleteById(int cartId) {
		logger.info("Remove cart item ");
		Optional<Cart> opt = crtRepo.findById(cartId);
		if (!opt.isPresent()) {
			return null;
		}
		Cart cart = opt.get();
		crtRepo.deleteById(cartId);
		return cart;
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
	
	
	@Override
	public Cart addCartToCustomer(int custId) {
		logger.info("adding Cart to customer");
		Optional<Customer> cust = custRepo.findById(custId);
		if (!cust.isPresent()) {
			return null;
		}
		Cart cart = new Cart();
		cust.get().setCart(cart);
		cart.setCartId(cart.getCartId());
		cart.setVegetables(cart.getVegetables());
		cart.setQuantity(cart.getQuantity());
		cart.setTotalAmount(cart.getTotalAmount());

		return crtRepo.save(cart);
	}

	@Override
	public void addProduct(Vegetable dto, int customerId) {
			logger.info("Adding products to the cart");
			Optional<Customer> cust = custRepo.findById(customerId);
			Cart cart = cust.get().getCart();
			if (cart.getVegetables().size() == 0) {
				cart.getVegetables().add(dto);
				crtRepo.save(cart); 
			} else
				for (int i = 0; i < cart.getVegetables().size(); i++) {
					if (cart.getVegetables().get(i).getVegId() == dto.getVegId()) {
						cart.getVegetables().get(i).setQuantity(dto.getQuantity() + 1);
						vegrepo.save(cart.getVegetables().get(i));

					} else {
						cart.getVegetables().add(dto);
					}
				}
		}
	@Override
	public List<Vegetable> getProductsInCart(int custId) {
		logger.info("View all products from the cart");
		Optional<Customer> cust = custRepo.findById(custId);
		Cart cart = cust.get().getCart();

		return Collections.unmodifiableList(cart.getVegetables());
	}
	
	@Override
	public Cart getTotalcost(int custId) {
		Optional<Customer> cust = custRepo.findById(custId);
		Cart cart = cust.get().getCart();
		double total=0;
		for(int i =0;i<cart.getVegetables().size();i++) {
		total+=cart.getVegetables().get(i).getPrice()*cart.getVegetables().get(i).getQuantity();
		cart.setTotalAmount(total);
		}
		return crtRepo.save(cart);
	}
	
	@Override
	public int totalQuantity(int custId) {
		Optional<Customer> cust = custRepo.findById(custId);
		Cart cart = cust.get().getCart();
		int total=0;
		for(int i =0;i<cart.getVegetables().size();i++) {
		total+=cart.getVegetables().get(i).getQuantity();
		}
		return total;

	}
	@Override
	public List<Vegetable> removeProduct(Vegetable product, int custId) {
		logger.info("Remove products from the cart");
		Optional<Customer> cust = custRepo.findById(custId);
		Cart cart = cust.get().getCart();

		for (int i = 0; i < cart.getVegetables().size(); i++) {
			if (cart.getVegetables().get(i).getVegId() == product.getVegId() && cart.getVegetables().get(i).getQuantity()>1) {
				cart.getVegetables().get(i).setQuantity(product.getQuantity() - 1);
				crtRepo.save(cart);
			} else {
				for (int j = 0; j < cart.getVegetables().size(); j++)
				if(cart.getVegetables().get(j).getVegId()==product.getVegId()) {
					cart.getVegetables().remove(j);
					crtRepo.save(cart);
				}
			}
		}
		return cart.getVegetables();
	}
		
	}