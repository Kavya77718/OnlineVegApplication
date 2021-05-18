package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vegetable.module.BillingDetails;

@SpringBootTest
class BillingServiceTest {

	@Autowired
	IBillingService billService;

	@Test
	@Disabled
	void testShouldAddBill() {

		BillingDetails bill = new BillingDetails(2, "COD", "02-01-1997", "SUCCESS");
		BillingDetails persistedBill = billService.save(bill);
		assertEquals(2, persistedBill.getBillingId());
		assertEquals("COD", persistedBill.getTransactionMode());
		assertEquals("02/01/1995", persistedBill.getTransactionDate());
		assertEquals("SUCCESS", persistedBill.getTransactionStatus());
	}

	@Test
	// @Disabled
	void testShouldUpdateBill() {

		BillingDetails bill = new BillingDetails(2, "COD", "02-01-1997", "SUCCESS");
		BillingDetails persistedBill = billService.updateBill(bill);
		assertEquals(2, persistedBill.getBillingId());
		assertEquals("COD", persistedBill.getTransactionMode());
		assertEquals("02/01/2001", persistedBill.getTransactionDate());
		assertEquals("SUCCESS", persistedBill.getTransactionStatus());
	}

	@Test
	// @Disabled
	void testShouldViewById() {
		BillingDetails details = billService.findById(2);
		assertEquals("sgdg", details.getTransactionMode());
		assertEquals("02-01-1999", details.getTransactionDate());
		assertEquals("SUCCESS", details.getTransactionStatus());
	}

	@Test
	@Disabled
	void testDeleteBill() {

		BillingDetails persistedBill = billService.deleteById(2);
		assertEquals(346, persistedBill.getBillingId());
		assertEquals("COD", persistedBill.getTransactionMode());
		assertEquals("02/01/1995", persistedBill.getTransactionDate());
		assertEquals("SUCCESS", persistedBill.getTransactionStatus());
	}
}
