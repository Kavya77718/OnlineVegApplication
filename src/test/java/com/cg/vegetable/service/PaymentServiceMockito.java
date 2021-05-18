package com.cg.vegetable.service;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.vegetable.module.Payments;
import com.cg.vegetable.repository.IPaymentRepository;

@SpringBootTest
class PaymentServiceMockito {

	@InjectMocks
	PaymentServiceImpl serviceimpl;
	
	@MockBean
	IPaymentRepository iordrep;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	//@Disabled
	public void testfindPaymentById() {
		Payments payById = new Payments(23,"Cash on Delivery",2.00, 0.00, 300.00);
		
		Mockito.when(iordrep.findById((long) 23)).thenReturn(Optional.of(payById));
		
		Payments pay = serviceimpl.findPaymentById(23);
		
		assertEquals(23,pay.getPaymentId());
		assertEquals(2.00, pay.getItemTotal());
	
	}
	
	@Test
	//@Disabled
	public void testsavePaymentDetails() {
		Payments payById = new Payments(26,"Cash on Delivery",2.00, 0.00, 500.00);
		
		Mockito.when(iordrep.findById((long) 26)).thenReturn(Optional.of(payById));
		Mockito.when(iordrep.save(payById)).thenReturn(payById);
		
		Payments payupdate = serviceimpl.save(payById);
		assertEquals(26,payupdate.getPaymentId());
		assertEquals(2.00, payupdate.getItemTotal());
	}
	
	@Test
	//@Disabled
	public void testDeletePaymentById() {
		Payments payById = new Payments(28,"Cash on Delivery",2.00, 0.00, 500.00);
		
		Mockito.when(iordrep.findById((long) 28)).thenReturn(Optional.of(payById));
		iordrep.deleteById((long) 28);
		Payments paydel = serviceimpl.deletePaymentById(28);

		assertEquals(28,paydel.getPaymentId());
		assertEquals(2.00, paydel.getItemTotal());
	}
		
	@Test
	//@Disabled
	void testFindAllPayments() {
		Payments payById1 = new Payments(30,"Cash on Delivery",2.00, 0.00, 500.00);
		Payments payById2 = new Payments(31,"Cash on Delivery",2.00, 0.00, 300.00);
		
		List<Payments> allOrders = new ArrayList<>();
		allOrders.add(payById1);
		allOrders.add(payById2);
	
		Mockito.when(iordrep.findAll()).thenReturn(allOrders);
		
		List<Payments> orderList = serviceimpl.findAllPayments();
		assertEquals(2,orderList.size());
	}
	 

}
