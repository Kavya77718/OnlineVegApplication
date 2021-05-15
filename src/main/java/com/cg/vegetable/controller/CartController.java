package com.cg.vegetable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vegetable.module.Cart;
import com.cg.vegetable.service.ICartService;
import com.cg.vegetable.service.IVegetableService;

@RestController
public class CartController {
	@Autowired
	ICartService vgs;
	
	@Autowired
	IVegetableService vs;
	
	@PostMapping("/cart")
	public Cart addToCart(@RequestBody Cart cart) {
		return vgs.addToCart(cart);
	}
	 @GetMapping("/cart/viewAllItems")
	 public List<Cart> viewAllItems(){
		return vgs.viewAllItems();	 
	 }
	 
	 @DeleteMapping("/cart/remove")
	 public void removeAllItems(){
		vgs.removeAllItems();
		

}

}
