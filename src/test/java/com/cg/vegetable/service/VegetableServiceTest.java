package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vegetable.module.Vegetable;

@SpringBootTest
class VegetableServiceTest {

	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(VegetableServiceTest.class);

	/**
	 * AutoWiring the service class to call down the service
	 */
	@Autowired
	IVegetableService es;

	/**
	 * This below function is used to Test the method FindAll Vegetables and
	 * redirects to the vegetable service
	 */
	@Test
	@Disabled
	void testFindAllVegetables() {
		List<Vegetable> vegetable = es.retrive();
		assertEquals(4, vegetable.size());
		logger.info("Found All Vegetables Successfully");
	}

	/**
	 * This below function is used to Test the method Find Vegetables by Id and
	 * redirects to the vegetable service
	 */

	@Test
	@Disabled
	void testFindVegetableById() {
		Vegetable vegetable = es.viewVegetableById(8);
		assertEquals(8, vegetable.getVegId());
		logger.info("Found All Vegetables By Id Successfully");

	}

	/**
	 * This below function is used to Test the method Find Vegetables by name and
	 * redirects to the vegetable service
	 */

	@Test
	@Disabled
	void testFindVegetableByName() {
		List<Vegetable> vegetable = es.viewVegetableByName("Radish");
		assertEquals(1, vegetable.size());
		logger.info("Found All Vegetables By Name Successfully");

	}

	/**
	 * This below function is used to Test the method Create Vegetables by name and
	 * redirects to the vegetable service
	 */

	@Test
	@Disabled
	void testCreateVegetable() {
		Vegetable vegetable = new Vegetable(10, "Cucumber", "Stem", 80, 25,"Cucumber has been found to decrease bad cholesterol and blood sugar levels as well.");
		Vegetable persistedveg = es.save(vegetable);
		assertEquals(10, persistedveg.getVegId());
		assertEquals("Cucumber", persistedveg.getName());
		assertEquals("Stem", persistedveg.getType());
		assertEquals(80, persistedveg.getPrice());
		assertEquals(25, persistedveg.getQuantity());
		logger.info("Created Successfully");
	}

	/**
	 * This below function is used to Test the method DeleteVegetable and redirects
	 * to the vegetable service
	 */
	@Test
	@Disabled
	void testDeleteVegetable() {
		Vegetable vegetable = es.deleteByvegId(4);
		assertEquals(4, vegetable.getVegId());
		logger.info("Deleted Successfully");

	}

}
