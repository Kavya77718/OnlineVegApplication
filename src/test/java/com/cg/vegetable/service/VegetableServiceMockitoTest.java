package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.vegetable.module.Vegetable;
import com.cg.vegetable.repository.IVegetableRepository;

@ExtendWith(SpringExtension.class)
class VegetableServiceMockitoTest {


	@InjectMocks
	VegetableServiceImpl as;

	@MockBean
	IVegetableRepository are;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAdd() {
		Vegetable a = new Vegetable(7, "Cucumber", "Stem", 80, 25,"Cucumber has been found to decrease bad cholesterol and blood sugar levels as well.");
		Mockito.when(are.save(a)).thenReturn(a);
		Vegetable vegetable = as.save(a);
		assertEquals(7, vegetable.getVegId());
	}

	@Test
	void viewAllVegetables() {
		Vegetable d1 = new Vegetable(1, "Radish", "Root", 10, 5,"Radish is also a good source of natural nitrates that improve blood flow.");
		Vegetable d2 = new Vegetable(2, "Brinjal", "Root", 55, 15,"A Great source of vitamins & minerals.");
		Vegetable d3 = new Vegetable(3, "Carrot", "Root", 45, 15,"Carrots are  loaded with vitamin A and beta-carotene, which there's evidence to suggest can lower your diabetes risk.");
		Vegetable d4 = new Vegetable(4, "Lettuse", "Leaves", 55, 5," Lettuce is also a good source of various other health-beneficial bioactive compounds. In vitro and in vivo studies have shown anti-inflammatory, cholesterol-lowering, and anti-diabetic activities attributed to the bioactive compounds in lettuce.");
		Vegetable d5 = new Vegetable(5, "Beetroot", "Root", 95, 8,"May improve muscle power in people with heart failure");

		List<Vegetable> l = new ArrayList<>();
		l.add(d1);
		l.add(d2);
		l.add(d3);
		l.add(d4);
		l.add(d5);
		Mockito.when(as.retrive()).thenReturn(l);
		List<Vegetable> vegetablelist = as.retrive();
		assertEquals(5, vegetablelist.size());
	}

	@Test
	//@Disabled
	void testFindVegetableById() {
		Vegetable r = new Vegetable(6, "Spinach", "Leaves", 10, 2,"Spinach gives good eye health, reduce oxidative stress, help prevent cancer, and reduce blood pressure levels.");
		Mockito.when(are.findById(6)).thenReturn(Optional.of(r));
		as.viewVegetableById(6);
		assertEquals(6, r.getVegId());

	}

	@Test
	void DeleteVegetableByIdTest() {
		Vegetable d = new Vegetable(7, "Cucumber", "Stem", 80, 25,"cucumber has been found to decrease bad cholesterol and blood sugar levels as well.");
		Mockito.when(are.findById(7)).thenReturn(Optional.of(d));
		as.deleteByvegId(7);
		assertEquals(7, d.getVegId());
	}
}
