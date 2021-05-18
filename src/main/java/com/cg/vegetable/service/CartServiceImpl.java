package com.cg.vegetable.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vegetable.module.Cart;
import com.cg.vegetable.module.Customer;
import com.cg.vegetable.module.OrderDet;
import com.cg.vegetable.module.Vegetable;
import com.cg.vegetable.repository.ICartRepository;
import com.cg.vegetable.repository.ICustomerRepository;
import com.cg.vegetable.repository.IVegetableRepository;



@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	ICartRepository crtRepo;
	
	@Autowired
	IVegetableRepository vrt;
	
	@Autowired
	ICustomerRepository custrepo;

	@Override
	public Cart addToCart(Cart cart) {
		return crtRepo.save(cart);
	}

	@Override
	public List<Cart> viewAllItems() {
		return crtRepo.findAll();
	}

	@Override
	public void removeAllItems() {
		
		 crtRepo.deleteAll();
	}
/*
	@Override
	public Cart calculateVegPriceBasedOnCustomerCartVegQuantity(int vegId, int customerId, int cartId, int quantity) {
		
		Optional<Cart> opt = crtRepo.findById(cartId);
		Optional<Vegetable> vege = vrt.findById(vegId);
		Optional<Customer> cust = custrepo.findById(customerId);
		if (!opt.isPresent()) {
			return null;
		}
		Vegetable dbveg = vege.get();
		Customer dbcust = cust.get();
		Cart cart = opt.get();
		Customer customer = cart.getCustomer(); 

		double totalCost = (OrderDet.class*distance)+vehicle.getFixedCharges();
		booking.setTotalCost(totalCost);
		return bokRepo.save(booking);
		
	}
}
		return null;*/
	

	
}