package com.cg.vegetable.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.vegetable.module.Vegetable;
import com.cg.vegetable.repository.IVegetableRepository;

@Service
public class VegetableServiceImpl implements IVegetableService {

	/**
	 * Logger
	 */

	org.apache.logging.log4j.Logger logger = LogManager.getLogger(VegetableServiceImpl.class);

	/**
	 * AutoWiring the repository class to call down the service
	 */
	@Autowired
	IVegetableRepository vegrepo;

	/**
	 * This below function is used to create a new vegetable and redirects to the
	 * vegetable repository
	 */
	@Override
	public Vegetable save(Vegetable dto) {
		logger.info("Successfully Added" + dto);
		return vegrepo.save(dto);
	}

	/**
	 * This below function is used to update a specific vegetable based on the give
	 * vegId and redirects to the vegetable repository
	 */

	@Override
	public Vegetable update(int vegId, Vegetable dto) {

		Vegetable v = vegrepo.findById(vegId).get();
		v.setVegId(dto.getVegId());
		v.setName(dto.getName());
		v.setPrice(dto.getPrice());
		v.setType(dto.getType());
		v.setQuantity(dto.getQuantity());
		logger.info("Update Successfully" + v);
		return vegrepo.save(v);
	}

	/**
	 * This below function is used to delete a specific vegetable based on the given
	 * vegId and redirects to the vegetable repository
	 */
	@Override
	public Vegetable deleteByvegId(int vegId) {
		Optional<Vegetable> opt = vegrepo.findById(vegId);
		if (!opt.isPresent()) {
			return null;
		}
		vegrepo.deleteById(vegId);
		return opt.get();
	}

	/**
	 * This below function is used to get a specific vegetable and vegId as
	 * parameter and redirects to the vegetable repository
	 */

	@Override
	public Vegetable viewVegetableById(int vegId) {
		Optional<Vegetable> opt = vegrepo.findById(vegId);
		if (!opt.isPresent()) {
			return null;
		}
		logger.info(" Viewed By Id Successfully " + opt);
		return opt.get();

	}

	/**
	 * This below function is used to get all the vegetables and redirects to the
	 * vegetable repository
	 */
	@Override
	public List<Vegetable> retrive() {
		logger.info("Viewed Successfully");
		return vegrepo.findAll();
	}

	/**
	 * This below function is used to get a specific vegetable and type as parameter
	 * and redirects to the vegetable repository
	 */
	@Override
	public List<Vegetable> viewVegetableList(String type) {
		logger.info("Viewed Successfully" + type);
		return vegrepo.findVegetableList(type);
	}

	/**
	 * This below function is used to get a specific vegetable and name as parameter
	 * and redirects to the vegetable repository
	 */

	@Override
	public List<Vegetable> viewVegetableByName(String name) {
		logger.info("Viewed Vegetable By Name Successfully" + name);
		return vegrepo.findVegetableByName(name);

	}
}
