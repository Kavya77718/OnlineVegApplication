package com.cg.vegetable.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}