package com.cg.vegetable.service;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vegetable.module.Payments;


@SpringBootTest
class PaymentServiceTest {
	
	@Autowired
	IPaymentService iservice;
	
	@Test
	//@Disabled
	public void testsavePaymentDetails() {
		Payments payById = iservice.findPaymentById(4);
		payById.setPaymentType("PhonePe");
		payById.setShippingFee(30.00);
		payById.setTotalPrice(130.00);
		Payments payupdate = iservice.save(payById);
		
		assertEquals("PhonePe",payupdate.getPaymentType());
		assertEquals(30.00, payupdate.getShippingFee());
		assertEquals(130.00, payupdate.getTotalPrice());
	}
	
	@Test
	//@Disabled
	public void testfindPaymentById() {
		Payments findById = iservice.findPaymentById(2);
		assertEquals(2.00,findById.getItemTotal());
		assertEquals(100.00, findById.getTotalPrice());
	
	}
	
	@Test
	//@Disabled
	void testFindAllPayments() {
		List<Payments> payment= iservice.findAllPayments();
		assertEquals(5,payment.size());
	}
	
	@Test
	//@Disabled
	void testdeletePaymentById() {
		Payments persistedPay = iservice.deletePaymentById(1);
		assertEquals(1,persistedPay.getPaymentId());
		assertEquals("Cash On Delivery",persistedPay.getPaymentType());
		assertEquals(2,persistedPay.getItemTotal());
	}
}
