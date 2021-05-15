package com.cg.vegetable.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.vegetable.module.Vegetable;


@Service
public interface IVegetableService {
	public Vegetable save(Vegetable dto);

	public Vegetable update(int vegId, Vegetable dto);

	public Vegetable deleteByvegId(int VegId);

	public Vegetable viewVegetableById(int VegId);

	public List<Vegetable> viewVegetableList(String type);

	public List<Vegetable> viewVegetableByName(String name);

	public List<Vegetable> retrive();
}

