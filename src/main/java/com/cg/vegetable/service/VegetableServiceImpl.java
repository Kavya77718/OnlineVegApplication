package com.cg.vegetable.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vegetable.module.Cart;
import com.cg.vegetable.module.Customer;
import com.cg.vegetable.module.Vegetable;
import com.cg.vegetable.repository.ICartRepository;
import com.cg.vegetable.repository.ICustomerRepository;
import com.cg.vegetable.repository.IVegetableRepository;

@Service
public class VegetableServiceImpl implements IVegetableService {
	@Autowired
	IVegetableRepository vegrepo;

	@Autowired
	ICartRepository cartrepo;

	@Autowired
	ICustomerRepository custrepo;

	@Override
	public Vegetable save(Vegetable dto) {
		return vegrepo.save(dto);
	}

	@Override
	public Vegetable update(int vegId, Vegetable dto) {

		Vegetable v = vegrepo.findById(vegId).get();
		v.setVegId(dto.getVegId());
		v.setName(dto.getName());
		v.setPrice(dto.getPrice());
		v.setType(dto.getType());
		v.setQuantity(dto.getQuantity());

		return vegrepo.save(v);
	}

	@Override
	public Vegetable deleteByvegId(int vegId) {
		Vegetable veg = vegrepo.findById(vegId).get();
		vegrepo.deleteById(vegId);
		return veg;
	}

	@Override
	public Vegetable viewVegetableById(int vegId) {
		Vegetable vgd = vegrepo.findById(vegId).get();
		return vgd;

	}

	@Override
	public List<Vegetable> retrive() {
		return vegrepo.findAll();
	}

	@Override
	public List<Vegetable> viewVegetableList(String type) {

		return vegrepo.findVegetableList(type);
	}

	@Override
	public List<Vegetable> viewVegetableByName(String name) {
		return vegrepo.findVegetableByName(name);

	}

	@Override
	public Vegetable addVegToCustomerCart(int vegId, int customerId, int cartId) {
		Optional<Vegetable> vege = vegrepo.findById(vegId);
		Optional<Customer> cust = custrepo.findById(customerId);
		Optional<Cart> cart = cartrepo.findById(cartId);

		if (!vege.isPresent() || !cust.isPresent() || !cart.isPresent()) {
			return null;

		}
		Vegetable dbveg = vege.get();
		Customer dbcust = cust.get();
		Cart dbcart = cart.get();
		if(dbcart.getCustomer().getCustomerId()==customerId) {
		dbcart.getVegetables().add(dbveg);
		}
	
		return vegrepo.save(dbveg);
	}/*

	@Override
	public Vegetable removeVegFromCustomerCart(int vegId, int customerId, int cartId) {
		Optional<Vegetable> vege = vegrepo.findById(vegId);
		Optional<Customer> cust = custrepo.findById(customerId);
		Optional<Cart> cart = cartrepo.findById(cartId);

		if (!vege.isPresent() || !cust.isPresent() || !cart.isPresent()) {
			return null;

		}
		Vegetable dbveg = vege.get();
		Customer dbcust = cust.get();
		Cart dbcart = cart.get();
		dbcart.getVegetables();
		dbveg.getCart().remove(dbcart);
		return vegrepo.save(dbveg);
	}

	@Override
	public Vegetable updateCustomerCartVegQuantity(int vegId, int customerId, int cartId, int quantity) {
		Optional<Vegetable> vege = vegrepo.findById(vegId);
		Optional<Customer> cust = custrepo.findById(customerId);
		Optional<Cart> cart = cartrepo.findById(cartId);

		if (!vege.isPresent() || !cust.isPresent() || !cart.isPresent()) {
			return null;

		} // cart->cust
			// veg->cart

		Vegetable dbveg = vege.get();
		Customer dbcust = cust.get();
		List<Cart> crt = dbveg.getCart();
		Cart cartwithCustomerId = null;
		for (int i = 0; i < crt.size(); i++) {
			if (crt.get(i).getCustomerId() == customerId) {
				cartwithCustomerId.setCustomer(crt.get(i).getCustomer());
			}
		}

		dbveg.setQuantity(quantity);

		return vegrepo.save(dbveg);
	}*/
}
