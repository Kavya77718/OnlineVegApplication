package com.cg.vegetable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vegetable.module.Vegetable;
import com.cg.vegetable.repository.IVegetableRepository;



@Service
public class VegetableServiceImpl implements IVegetableService {
	@Autowired
	IVegetableRepository vr;

	@Override
	public Vegetable save(Vegetable dto) {
		return vr.save(dto);
	}

	@Override
	public Vegetable update(int VegId, Vegetable dto) {

		Vegetable v = vr.findById(VegId).get();
		v.setVegId(dto.getVegId());
		v.setName(dto.getName());
		v.setPrice(dto.getPrice());
		v.setType(dto.getType());
		v.setQuantity(dto.getQuantity());

		return vr.save(v);
	}

	@Override
	public Vegetable deleteByvegId(int VegId) {
		Vegetable veg = vr.findById(VegId).get();
		vr.deleteById(VegId);
		return veg;
	}

	@Override
	public Vegetable viewVegetableById(int VegId) {
		Vegetable vgd = vr.findById(VegId).get();
		return vgd;

	}

	@Override
	public List<Vegetable> retrive() {
		return vr.findAll();
	}

	@Override
	public List<Vegetable> viewVegetableList(String type) {

		return vr.findVegetableList(type);
	}

	@Override
	public List<Vegetable> viewVegetableByName(String name) {
		return vr.findVegetableByName(name);

	}

	

}
