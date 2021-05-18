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
	IVegetableRepository vegrepo;
	
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

	@Override
	public Vegetable UpdateVegQuantity(int vegId, int quantity) {
		Optional<Vegetable> vegetable = vegrepo.findById(vegId);
		if(!vegetable.isPresent()) {
			return null;
		}
		Vegetable veg = vegetable.get();
		veg.getQuantity();
		veg.setQuantity(quantity);
		
		return vegrepo.save(veg);
	}

}