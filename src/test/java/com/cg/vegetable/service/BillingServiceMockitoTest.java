
package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

import com.cg.vegetable.module.BillingDetails;
import com.cg.vegetable.repository.IBillingRepository;

@ExtendWith(SpringExtension.class)
class BillingServiceMockitoTest {
	@InjectMocks
	BillingService billingService;

	@MockBean
	IBillingRepository billingRepository;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	/**
	 * This below function is used to Test the method testFindAllBills and to check
	 * whether it finds all bills from the database
	 */
	// Find all bills
	@Test
	// @Disabled
	void testFindAllBills() {
		List<BillingDetails> bill = billingService.viewAllBills();
		assertEquals(10, bill.size());
	}

	/**
	 * This below function is used to Test the method testViewAllBills and to check
	 * whether it retrieves bills from the database
	 */
	@Test
	// @Disabled
	void testViewAllBills() {
		BillingDetails bill1 = new BillingDetails(348);
		BillingDetails bill2 = new BillingDetails(349);
		List<BillingDetails> billList = new ArrayList<>();
		billList.add(bill1);
		billList.add(bill2);
		Mockito.when(billingRepository.findAll()).thenReturn(billList);
		List<BillingDetails> bill = billingService.viewAllBills();
		assertEquals(2, bill.size());
	}

	/**
	 * This below function is used to Test the method testShouldAddBill and to check
	 * whether it adds bill to the database
	 */

	@Test

	void testShouldAddBill() {
		BillingDetails bill = new BillingDetails(343);
		Mockito.when(billingRepository.save(bill)).thenReturn(bill);
		BillingDetails persistedBillingDetails = billingService.save(bill);
		assertEquals(343, persistedBillingDetails.getBillingId());
		

	}

	/**
	 * This below function is used to Test the method testShouldUpdateBill and to
	 * check whether it is updating the bill in the database
	 */
	@Test

	void testShouldUpdateBill() {
		BillingDetails bill = new BillingDetails(344);
		Mockito.when(billingRepository.findById(344)).thenReturn(Optional.of(bill));
		Mockito.when(billingRepository.save(bill)).thenReturn(bill);
		BillingDetails persistedBillingDetails = billingService.updateBill(344, bill);
		assertEquals(344, persistedBillingDetails.getBillingId());
		

	}

	/**
	 * This below function is used to Test the method testShouldViewById and to
	 * check whether it retrieves bills from the database
	 */
	@Test
	@Disabled
	void testShouldViewById() {
		BillingDetails bill = new BillingDetails(345);

		Mockito.when(billingRepository.findById(345)).thenReturn(Optional.of(bill));

		BillingDetails persistedBill = billingService.findById(345);

		assertEquals(345, persistedBill.getBillingId());
	}

	/**
	 * This below function is used to Test the method testShouldDeleteBill and to
	 * check whether it deletes bill by Id from the database
	 */
	@Test
	@Disabled
	void testShouldDeleteBill() {
		BillingDetails bill = new BillingDetails(341);
		Mockito.when(billingRepository.findById(341)).thenReturn(Optional.of(bill));
		billingRepository.deleteById(341);
		BillingDetails persistedBillingDetails = billingService.deleteById(341);
		assertEquals(341, persistedBillingDetails.getBillingId());
	
	}
}
