package com.cg.vegetable.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.vegetable.module.BillingDetails;
import com.cg.vegetable.repository.IBillingRepository;

@Service
public class BillingService implements IBillingService {
	/**
	 * Logger
	 */

	org.apache.logging.log4j.Logger logger = LogManager.getLogger(BillingService.class);
	/**
	 * AutoWiring the IBillingRepository class to call down the service
	 */
	@Autowired
	IBillingRepository billRepo;

	// addBill
	@Override
	public BillingDetails addBill(BillingDetails bill) {
		logger.info("Adding Billing Details To The Database");
		return billRepo.save(bill);
	}

	/**
	 * To List all the bill by id called from the controller class and send back to
	 * the Controller
	 */
	// viewBill By Id
	@Override
	public BillingDetails viewBill(int billingId) {
		logger.info("Viewing Bill  By Id From The Database");
		Optional<BillingDetails> vegBill = billRepo.findById(billingId);
		if (!vegBill.isPresent()) {
			return null;
		}
		return vegBill.get();
	}

	/**
	 * This below function findAllCustomer is used to get all the customers and
	 * redirects to custRepo.
	 */
	@Override
	public List<BillingDetails> viewAllBills() {
		logger.info("getting list of customer");
		return billRepo.findAll();
	}

	/**
	 * To Update all the bill called from the controller class and send back to the
	 * Controller
	 */
	// updateBill By Id
	@Override
	public BillingDetails updateBill(int billingId, BillingDetails bill) {
		logger.info("Updating Bill By id");
		Optional<BillingDetails> vegBill = billRepo.findById(billingId);
		if (!vegBill.isPresent()) {
			return null;
		}
		vegBill.get().setBillingId(bill.getBillingId());
		vegBill.get().setTransactionMode(bill.getTransactionMode());
		vegBill.get().setTransactionStatus(bill.getTransactionStatus());
		vegBill.get().setTransactionDate(bill.getTransactionDate());
		return billRepo.save(vegBill.get());
	}

	/**
	 * To Delete bill by Id from the controller class
	 */
	// deleteBill By Id
	@Override
	public BillingDetails deleteById(int billingId) {
		logger.info("Deleting Bill By id");
		Optional<BillingDetails> vegBill = billRepo.findById(billingId);
		if (!vegBill.isPresent()) {
			return null;
		}
		billRepo.deleteById(billingId);
		return vegBill.get();

	}

	// saveBill
	public BillingDetails save(BillingDetails bill) {
		logger.info("saving Bill By id");
		return billRepo.save(bill);
	}

	public BillingDetails findById(int billingId) {
		logger.info("Find Bill By id");
		BillingDetails bill = billRepo.findById(billingId).get();
		return bill;
	}

}