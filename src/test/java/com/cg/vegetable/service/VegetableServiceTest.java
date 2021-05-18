package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vegetable.module.Vegetable;


@SpringBootTest
class VegetableServiceTest {

	@Autowired
	IVegetableService es;

	@Test
	void testFindAllVegetables() {
		List<Vegetable> vegetable = es.retrive();
		assertEquals(4, vegetable.size());
	}

	@Test

	void testFindVegetableById() {
		Vegetable vegetable = es.viewVegetableById(1);
		assertEquals(1, vegetable.getVegId());

	}

	@Test
	void testFindVegetableByName() {
		List<Vegetable> vegetable = es.viewVegetableByName("Radish");
		assertEquals(1, vegetable.size());
	}

	@Test
	void testCreateVegetable() {
		Vegetable vegetable = new Vegetable(10, "Cucumber", "Stem", 80, 25);
		Vegetable persistedveg = es.save(vegetable);
		assertEquals(10, persistedveg.getVegId());
		assertEquals("Cucumber", persistedveg.getName());
		assertEquals("Stem", persistedveg.getType());
		assertEquals(80, persistedveg.getPrice());
		assertEquals(25, persistedveg.getQuantity());
	}

	@Test

	void testDeleteVegetable() {
		Vegetable vegetable = es.deleteByvegId(4);
		assertEquals(4, vegetable.getVegId());

	}

}
