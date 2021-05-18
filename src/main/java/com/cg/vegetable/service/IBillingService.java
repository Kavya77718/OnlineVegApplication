package com.cg.vegetable.service;

import org.springframework.stereotype.Service;

import com.cg.vegetable.module.BillingDetails;
@Service
public interface IBillingService {
	BillingDetails addBill(BillingDetails bill);

	BillingDetails updateBill(BillingDetails bill);

	BillingDetails viewBill(int billingId);

	BillingDetails save(BillingDetails details);

	BillingDetails deleteById(int billingId);

	BillingDetails findById(int billingId);
}
