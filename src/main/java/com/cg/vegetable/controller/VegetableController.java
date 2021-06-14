package com.cg.vegetable.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vegetable.exception.VegetableNotFoundException;
import com.cg.vegetable.module.Vegetable;
import com.cg.vegetable.service.IVegetableService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class VegetableController {

	/**
	 * Logger
	 */

	org.apache.logging.log4j.Logger logger = LogManager.getLogger(VegetableController.class);

	/**
	 * AutoWiring the service class to call down the service
	 */

	@Autowired
	IVegetableService vegsev;

	
	/**
	 * This below function is used to create a new vegetable and redirects to the
	 * vegetable service
	 */
	@PostMapping("/vegetable")
	public ResponseEntity<Vegetable> addVegetable(@Valid @RequestBody Vegetable vegetable) {
		vegsev.save(vegetable);
		logger.info("adding values");
		return ResponseEntity.ok(vegetable);

	}

	/**
	 * This below function is used to update a specific vegetable based on the given
	 * vegId and redirects to the vegetable service
	 */

	@PutMapping("/vegetable/update/{id}")
	public ResponseEntity<Vegetable> update(@PathVariable("id") int vegId, @Valid @RequestBody Vegetable dto) {

		if (vegsev.update(vegId, dto) == null) {
			throw new VegetableNotFoundException("Vegetable not found with given id: " + vegId);
		}
		logger.info("Updated Successfully" + vegId);
		Vegetable veg = vegsev.update(vegId, dto);
		return ResponseEntity.ok(veg);

	}

	/**
	 * This below function is used to delete a specific vegetable based on the given
	 * vegId and redirects to the vegetable service
	 */

	@DeleteMapping("/vegetable/{id}")
	public Vegetable remove(@PathVariable("id") int vegId) {

		if (vegsev.viewVegetableById(vegId) == null) {
			throw new VegetableNotFoundException("Vegetable not found with given id: " + vegId);
		}
		logger.info("Deleted Successfully" + vegId);
		return vegsev.deleteByvegId(vegId);
	}

	/**
	 * This below function is used to get a specific vegetable and vegId as
	 * parameter and redirects to the vegetable service
	 */

	@GetMapping("/vegetable/viewvegetablebyid/{id}")
	public ResponseEntity<Vegetable> viewVegetableById(@PathVariable("id") int vegId) {
		if (vegsev.viewVegetableById(vegId) == null) {
			throw new VegetableNotFoundException("Vegetable not found with given Id: " + vegId);
		}
		logger.info("viewedById" + vegId);
		Vegetable vegetable = vegsev.viewVegetableById(vegId);
		return ResponseEntity.ok(vegetable);
	}

	/**
	 * This below function is used to get all the vegetables and redirects to the
	 * vegetable service
	 */
	@GetMapping("/vegetable/view")
	public ResponseEntity<List<Vegetable>> viewAllVegetables() {
		logger.info("Viewed All Vegetables");
		List<Vegetable> vegetable = vegsev.retrive();
		return ResponseEntity.ok(vegetable);
	}

	/**
	 * This below function is used to get a specific vegetable and type as parameter
	 * and redirects to the vegetable service
	 */

	@GetMapping("/vegetable/type/{type}")
	public ResponseEntity<List<Vegetable>> viewVegetableList(@PathVariable("type") String type) {
		if (vegsev.viewVegetableList(type) == null) {
			throw new VegetableNotFoundException("Vegetable not found with given type: " + type);
		}
		logger.info("Viewed VegetableList" + type);
		List<Vegetable> vegetable = vegsev.viewVegetableList(type);
		return ResponseEntity.ok(vegetable);
	}

	/**
	 * This below function is used to get a specific vegetable and name as parameter
	 * and redirects to the vegetable service
	 */

	@GetMapping("/vegetable/name/{name}")
	public ResponseEntity<List<Vegetable>> viewVegetableByName(@PathVariable("name") String name) {
		if (vegsev.viewVegetableByName(name) == null) {
			throw new VegetableNotFoundException("Vegetable not found with given name: " + name);
		}
		logger.info("Viewed Vegetable By Name" + name);
		List<Vegetable> vegetable = vegsev.viewVegetableByName(name);
		return ResponseEntity.ok(vegetable);

	}

}