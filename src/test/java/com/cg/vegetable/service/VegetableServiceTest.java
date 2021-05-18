package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vegetable.module.Vegetable;


@SpringBootTest
class VegetableServiceTest {

	@Autowired
	IVegetableService es;

	@Test
	@Disabled
	void testFindAllVegetables() {
		List<Vegetable> vegetable = es.retrive();
		assertEquals(4, vegetable.size());
	}

	@Test
	@Disabled
	void testFindVegetableById() {
		Vegetable vegetable = es.viewVegetableById(1);
		assertEquals(1, vegetable.getVegId());

	}

	@Test
	@Disabled
	void testFindVegetableByName() {
		List<Vegetable> vegetable = es.viewVegetableByName("Radish");
		assertEquals(1, vegetable.size());
	}

	@Test
	@Disabled
	void testCreateVegetable() {
		Vegetable vegetable = new Vegetable(4, "Cucumber", "Climber", 80, 25);
		Vegetable persistedveg = es.save(vegetable);
		assertEquals(4, persistedveg.getVegId());
		assertEquals("Cucumber", persistedveg.getName());
		assertEquals("Climber", persistedveg.getType());
		assertEquals(80, persistedveg.getPrice());
		assertEquals(25, persistedveg.getQuantity());
	}

	@Test
	@Disabled
	void testDeleteVegetable() {
		Vegetable vegetable = es.deleteByvegId(4);
		assertEquals(4, vegetable.getVegId());

	}

}
