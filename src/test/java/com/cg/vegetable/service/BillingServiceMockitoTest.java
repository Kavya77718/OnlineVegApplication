package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

	@Test
	void testShouldAddBill() {
		BillingDetails bill = new BillingDetails(2, "COD", "02-01-1997", "SUCCESS");
		Mockito.when(billingRepository.save(bill)).thenReturn(bill);
		BillingDetails persistedBillingDetails = billingService.save(bill);
		assertEquals(2, persistedBillingDetails.getBillingId());
		assertEquals("COD", persistedBillingDetails.getTransactionMode());
		assertEquals("02-01-1997", persistedBillingDetails.getTransactionDate());
		assertEquals("SUCCESS", persistedBillingDetails.getTransactionStatus());

	}

	@Test
	@Disabled
	void testShouldUpdateBill() {

		BillingDetails bill = new BillingDetails(2, "COD", "02-01-1997", "FAILED");
		Mockito.when(billingRepository.findById(2)).thenReturn(Optional.of(bill));
		Mockito.when(billingRepository.save(bill)).thenReturn(bill);
		BillingDetails persistedBillingDetails = billingService.updateBill(bill);
		assertEquals(2, persistedBillingDetails.getBillingId());
		assertEquals("FAILED", persistedBillingDetails.getTransactionStatus());

	}

	@Test
	@Disabled
	void testShouldViewById() {

		BillingDetails bill = new BillingDetails(2, "COD", "02-01-1997", "SUCCESS");

		Mockito.when(billingRepository.findById(345)).thenReturn(Optional.of(bill));

		BillingDetails persistedBill = billingService.findById(345);

		assertEquals(2, persistedBill.getBillingId());
	}

	@Test
	@Disabled
	void testShouldDeleteBill() {

		BillingDetails bill = new BillingDetails(2, "COD", "02-01-1997", "SUCCESS");
		Mockito.when(billingRepository.findById(341)).thenReturn(Optional.of(bill));
		billingRepository.deleteById(341);
		BillingDetails persistedBillingDetails = billingService.deleteById(341);
		assertEquals(2, persistedBillingDetails.getBillingId());
		assertEquals("SUCCESS", persistedBillingDetails.getTransactionStatus());
	}
}
