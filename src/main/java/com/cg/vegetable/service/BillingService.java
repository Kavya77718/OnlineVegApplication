package com.cg.vegetable.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vegetable.module.BillingDetails;
import com.cg.vegetable.repository.IBillingRepository;



@Service
public class BillingService implements IBillingService {

	
	@Autowired
	static
 	IBillingRepository billRepo;  


@Override
public BillingDetails addBill(BillingDetails bill)
{
	return billRepo.save(bill);
}


@Override 
public BillingDetails updateBill(BillingDetails bill) 
{

	
	Optional<BillingDetails> vegBill=billRepo.findById(bill.getBillingId()); 
	if(!vegBill.isPresent()) {
		return null;
	}
	vegBill.get().setBillingId(bill.getBillingId());
	vegBill.get().setTransactionMode(bill.getTransactionMode());
	vegBill.get().setTransactionStatus(bill.getTransactionStatus());
	vegBill.get().setTransactionDate(bill.getTransactionDate());
	return billRepo.save(vegBill.get());
}
  

@Override
public BillingDetails viewBill(int billingId) {
	
	Optional<BillingDetails> vegBill=billRepo.findById(billingId);
	if(!vegBill.isPresent()) {
		return null;
	}
	return vegBill.get();
}
	
	public BillingDetails deleteById(int billingId) {
		Optional <BillingDetails> vegBill=billRepo.findById(billingId);
		if(!vegBill.isPresent()) 
		{	
		return null;	
	    }
		billRepo.deleteById(billingId);
		return vegBill.get();
		
	}


	public BillingDetails save(BillingDetails bill) {

		return billRepo.save(bill);
	}

	public BillingDetails findById(int billingId) {
		
			BillingDetails bill = billRepo.findById(billingId).get();
			return bill;
		}



}