package com.cg.vegetable.service;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
		Payments payById = iservice.findPaymentById(25);
		payById.setPaymentType("PhonePe");
		payById.setShippingFee(30.00);
		payById.setTotalPrice(330.00);
		Payments payupdate = iservice.save(payById);
		
		assertEquals("PhonePe",payupdate.getPaymentType());
		assertEquals(30.00, payupdate.getShippingFee());
		assertEquals(330.00, payupdate.getTotalPrice());
	}
	
	@Test
	//@Disabled
	public void testfindPaymentById() {
		Payments findById = iservice.findPaymentById(26);
		assertEquals(2.00,findById.getItemTotal());
		assertEquals(300.00, findById.getTotalPrice());
	
	}
	
	@Test
	//@Disabled
	void testFindAllPayments() {
		List<Payments> payment= iservice.findAllPayments();
		assertEquals(4,payment.size());
	}
	
	@Test
	@Disabled
	void testdeletePaymentById() {
		Payments persistedPay = iservice.deletePaymentById(27);
		assertEquals(27,persistedPay.getPaymentId());
		assertEquals("Cash On Delivery",persistedPay.getPaymentType());
		assertEquals(2,persistedPay.getItemTotal());
	}
}
