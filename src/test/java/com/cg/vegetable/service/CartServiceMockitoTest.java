package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.vegetable.module.Cart;
import com.cg.vegetable.repository.ICartRepository;

@ExtendWith(SpringExtension.class)
class CartServiceMockitoTest {

	@InjectMocks
	CartServiceImpl cartser;

	@MockBean
	ICartRepository cartrepo;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAdd() {
		Cart cart = new Cart(6,22.00);
		Mockito.when(cartrepo.save(cart)).thenReturn(cart);
		Cart vegetable = cartser.addToCart(cart);
		assertEquals(6, vegetable.getCartId());
	}

	@Test
	@Disabled
	void viewAllItems() {
		Cart d1 = new Cart(1,100);
		Cart d2 = new Cart(2,50);
		Cart d3 = new Cart(3,75);
		Cart d4 = new Cart(4,25);
		Cart d5 = new Cart(5,90);
		Cart d6 = new Cart(6,55);

		List<Cart> l = new ArrayList<>();
		l.add(d1);
		l.add(d2);
		l.add(d3);
		l.add(d4);
		l.add(d5);
		l.add(d6);
		Mockito.when(cartrepo.findAll()).thenReturn(l);
		List<Cart> cartlist = cartrepo.findAll();
		assertEquals(6, cartlist.size());
	}

}
