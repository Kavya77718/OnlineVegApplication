package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vegetable.module.BillingDetails;

@SpringBootTest
class BillingServiceTest {
	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(BillingServiceTest.class);
	/**
	 * AutoWiring the BillingServiceTest class to call down the service
	 */
	@Autowired
	IBillingService billService;

	/**
	 * This below function is used to Test the method testViewAllBills and to check
	 * whether it retrieves bills from the database
	 */
	@Test
	@Disabled
	void testShouldAddBill() {

		BillingDetails bill = new BillingDetails(2);
		BillingDetails persistedBill = billService.save(bill);
		assertEquals(2, persistedBill.getBillingId());
		logger.info(bill);
		logger.info("Added Bill Successfully");
	}

	/**
	 * This below function is used to Test the method testShouldUpdateBill and to
	 * check whether it is updating the bill in the database
	 */
	@Test
	// @Disabled
	void testShouldUpdateBill() {

		BillingDetails bill = new BillingDetails(2);
		BillingDetails persistedBill = billService.updateBill(2, bill);
		assertEquals(2, persistedBill.getBillingId());
		logger.info(bill);
		logger.info("Updated Bill Successfully");
	}

	/**
	 * This below function is used to Test the method testViewAllBills and to check
	 * whether it retrieves bills from the database
	 */
	// viewAll Bill
	@Test
	// @Disabled
	void testViewAllBill() {
		List<BillingDetails> bill = billService.viewAllBills();
		logger.info(bill);
		assertEquals(10, bill.size());
	}

	/**
	 * This below function is used to Test the method testShouldViewById and to
	 * check whether it retrieves bills from the database
	 **/
	@Test
	// @Disabled
	void testShouldViewById() {
		BillingDetails details = billService.findById(2);
		logger.info(details);
		logger.info("Viewing Bill By Id Successfully");
	}

	/**
	 * This below function is used to Test the method testShouldDeleteBill and to
	 * check whether it deletes bill by Id from the database
	 */
	@Test
	@Disabled
	void testDeleteBill() {
		BillingDetails persistedBill = billService.deleteById(2);
		assertEquals(346, persistedBill.getBillingId());
		logger.info(persistedBill);
		logger.info("Deleted Bill Successfully");
	}
}
