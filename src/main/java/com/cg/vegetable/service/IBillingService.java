package com.cg.vegetable.service;

import com.cg.vegetable.module.BillingDetails;

public interface IBillingService {
	BillingDetails addBill(BillingDetails bill);

	BillingDetails updateBill(BillingDetails bill);

	BillingDetails viewBill(int billingId);

	BillingDetails save(BillingDetails details);

	BillingDetails deleteById(int billingId);

	BillingDetails findById(int billingId);
}
