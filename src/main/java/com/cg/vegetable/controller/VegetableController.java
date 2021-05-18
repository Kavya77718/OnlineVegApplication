package com.cg.vegetable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vegetable.exception.VegetableNotFoundException;
import com.cg.vegetable.module.Cart;
import com.cg.vegetable.module.Customer;
import com.cg.vegetable.module.Vegetable;
import com.cg.vegetable.service.IVegetableService;

@RestController
public class VegetableController {

	@Autowired
	IVegetableService vegsev;

	@PostMapping("/vegetable")
	public Vegetable addVegetable(@RequestBody Vegetable dto) {
		return vegsev.save(dto);

	}

	@PutMapping("/vegetable/{id}")
	public Vegetable update(@PathVariable("id") int VegId, @RequestBody Vegetable dto) {

		if (vegsev.viewVegetableById(VegId) == null) {
			throw new VegetableNotFoundException("Vegetable not found with given id: " + VegId);
		}
		return vegsev.update(VegId, dto);
	}

	@DeleteMapping("/vegetable/id/{id}")
	public Vegetable remove(@PathVariable("id") int VegId) {

		if (vegsev.viewVegetableById(VegId) == null) {
			throw new VegetableNotFoundException("Vegetable not found with given id: " + VegId);
		}
		return vegsev.deleteByvegId(VegId);
	}

	@GetMapping("/vegetable/viewvegetablebyid/{id}")
	public Vegetable viewVegetableById(@PathVariable("id") int VegId) {
		if (vegsev.viewVegetableById(VegId) == null) {
			throw new VegetableNotFoundException("Vegetable not found with given Id: " + VegId);
		}
		return vegsev.viewVegetableById(VegId);
	}

	@GetMapping("/vegetable/view")
	public List<Vegetable> viewAllVegetables() {
		return vegsev.retrive();

	}

	@GetMapping("/vegetable/type/{type}")
	public List<Vegetable> viewVegetableList(@PathVariable("type") String type) {
		if (vegsev.viewVegetableList(type) == null) {
			throw new VegetableNotFoundException("Vegetable not found with given type: " + type);
		}
		return vegsev.viewVegetableList(type);

	}

	@GetMapping("/vegetable/name/{name}")
	public List<Vegetable> viewVegetableByName(@PathVariable("name") String name) {
		if (vegsev.viewVegetableByName(name) == null) {
			throw new VegetableNotFoundException("Vegetable not found with given name: " + name);
		}
		return vegsev.viewVegetableByName(name);

	}

	@PostMapping("/vegetable/add/{vegid}/{custid}/{cartid}")
	public Vegetable addVegToCustomerCart(@PathVariable ("vegid") int vegId ,@RequestBody Vegetable vegetable ,@PathVariable ("custid") int customerId, @RequestBody Cart cart ,@PathVariable ("cartid") int cartId,@RequestBody Customer customer) {

		return vegsev.addVegToCustomerCart(vegId, customerId, cartId);

	}

}