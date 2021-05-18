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
class BillingServiceMockitoTest 
    {
		@InjectMocks
		BillingService billingService;
		
		@MockBean
		IBillingRepository billingRepository;
		
		@BeforeEach
		void init() {
			MockitoAnnotations.openMocks(this);
		}
		
		@Test
	    @Disabled
		void testShouldAddBill() {
			BillingDetails bill = new BillingDetails(343,"COD","02-01-1997","SUCCESS");
			Mockito.when(billingRepository.save(bill)).thenReturn(bill);
			BillingDetails persistedBillingDetails = billingService.save(bill);
			assertEquals(343,persistedBillingDetails.getBillingId());
			assertEquals("COD",persistedBillingDetails.getTransactionMode());
			assertEquals("02-01-1997",persistedBillingDetails.getTransactionDate());
			assertEquals("SUCCESS",persistedBillingDetails.getTransactionStatus());
			
		}
		
		@Test
		@Disabled
		void testShouldUpdateBill() {
			BillingDetails bill= new BillingDetails(344,"DebitCard","02-01-1999","FAILED");
		    Mockito.when(billingRepository.findById(344)).thenReturn(Optional.of(bill));
			Mockito.when(billingRepository.save(bill)).thenReturn(bill);
			BillingDetails persistedBillingDetails = billingService.updateBill(bill);
		    assertEquals(344,persistedBillingDetails.getBillingId());
			assertEquals("FAILED",persistedBillingDetails.getTransactionStatus());
							
		}
		
		@Test
		@Disabled
		void testShouldViewById() {
			BillingDetails bill = new BillingDetails(345,"DebitCard","02-01-1999","SUCCESS");
			
			Mockito.when(billingRepository.findById(345)).thenReturn(Optional.of(bill));
			
			BillingDetails  persistedBill= billingService.findById(345);
			
			assertEquals(345, persistedBill.getBillingId());
			//assertEquals("", persistedBill.getDept());
		}
		
	@Test
	@Disabled
	void testShouldDeleteBill() 
	{
			BillingDetails bill= new BillingDetails(341,"COD","31/04/1993","SUCCESS");
			Mockito.when(billingRepository.findById(341)).thenReturn(Optional.of(bill));
			billingRepository.deleteById(341);
			BillingDetails persistedBillingDetails = billingService.deleteById(341);
			assertEquals(341,persistedBillingDetails.getBillingId());
			assertEquals("SUCCESS",persistedBillingDetails.getTransactionStatus())	;
	}
	}

