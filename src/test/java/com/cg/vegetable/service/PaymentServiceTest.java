package com.cg.vegetable.service;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vegetable.module.Payments;


@SpringBootTest
class PaymentServiceTest {
	
	//Logger
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(PaymentServiceTest.class);
			
	//AutoWiring the PaymentService class to call down the service
	@Autowired
	IPaymentService iservice;
	
	// Testing whether the payment is updating into the database or not
	@Test
	//@Disabled
	public void testsavePaymentDetails() {
		Payments payById = iservice.findPaymentById(4);
		payById.setTransactionMode("PhonePe");
		payById.setShippingFee(30.00);
		payById.setTotalPrice(130.00);
		Payments payupdate = iservice.save(payById);
		assertEquals("PhonePe",payupdate.getTransactionMode());
		assertEquals(30.00, payupdate.getShippingFee());
		assertEquals(130.00, payupdate.getTotalPrice());
		logger.info(payById);
		logger.info("Updated payment successfully");
	}
	
	// Testing whether the given id fetches the given payment or not from the database.
	@Test
	//@Disabled
	public void testfindPaymentById() {
		Payments findById = iservice.findPaymentById(2);
		assertEquals(2.00,findById.getItemTotal());
		assertEquals(100.00, findById.getTotalPrice());
		logger.info(findById);
		logger.info("found payment successfully");
		
	}
	
	//testing whether it is fetching list of all the payments from the database or not
	@Test
	//@Disabled
	void testFindAllPayments() {
		List<Payments> payment= iservice.findAllPayments();
		assertEquals(5,payment.size());
		logger.info(payment);
		logger.info("found list of payments successfully");
	}
	
	// Testing whether the given id is getting deleted from the database or not.
	@Test
	@Disabled
	void testdeletePaymentById() {
		Payments persistedPay = iservice.deletePaymentById(1);
		assertEquals(1,persistedPay.getPaymentId());
		assertEquals("Cash On Delivery",persistedPay.getTransactionMode());
		assertEquals(2,persistedPay.getItemTotal());
		logger.info(persistedPay);
		logger.info("deleted order successfully");
	}
}
