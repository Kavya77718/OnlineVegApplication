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
	@Disabled
	void testAdd(){
		Cart cart=new Cart(4, 103);
		Mockito.when(cartrepo.save(cart)).thenReturn(cart);
		Cart vegetable=cartser.addToCart(cart);
		assertEquals(4,vegetable.getCartId());
	}
	@Test
	@Disabled
	void viewAllItems() {
		Cart d1=new Cart(1,100);
		Cart d2=new Cart(2,101);
		Cart d3=new Cart(3,102);
		
		List<Cart>l=new ArrayList<>();
		l.add(d1);
		l.add(d2);
		l.add(d3);
		Mockito.when(cartrepo.findAll()).thenReturn(l);
		List<Cart>cartlist=cartrepo.findAll();
		assertEquals(3,cartlist.size());
	}
	
}
