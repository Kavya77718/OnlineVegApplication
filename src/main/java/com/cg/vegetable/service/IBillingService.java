package com.cg.vegetable.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.vegetable.module.BillingDetails;

@Service
public interface IBillingService {
	BillingDetails addBill(BillingDetails bill);

	BillingDetails viewBill(int billingId);

	BillingDetails save(BillingDetails details);

	BillingDetails deleteById(int billingId);

	BillingDetails findById(int billingId);

	BillingDetails updateBill(int billingId, BillingDetails bill);

	List<BillingDetails> viewAllBills();
}
