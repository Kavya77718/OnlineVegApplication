package com.cg.vegetable.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vegetable.module.Cart;
import com.cg.vegetable.repository.ICartRepository;
import com.cg.vegetable.repository.IVegetableRepository;



@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	ICartRepository crtRepo;
	
	@Autowired
	IVegetableRepository vrt;

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

	

	
}