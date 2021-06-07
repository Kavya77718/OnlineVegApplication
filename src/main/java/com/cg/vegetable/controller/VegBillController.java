package com.cg.vegetable.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vegetable.exception.VegBillingIdNotFoundException;
import com.cg.vegetable.module.BillingDetails;
import com.cg.vegetable.module.VegErrorResponse;
import com.cg.vegetable.service.IBillingService;

@CrossOrigin
@RestController
public class VegBillController {
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(VegBillController.class);

	/**
	 * AutoWiring the IBillingService class to call down the service
	 */
	@Autowired
	IBillingService bs;

	/**
	 * This below function is used to add a new bill and redirects to the
	 * Billing Service
	 */

	// addBill
	@PostMapping("/billing")
	public ResponseEntity <BillingDetails> addBill(@Valid @RequestBody BillingDetails bill) {
		logger.info("Adding Bill in database" + bill);
		BillingDetails billing= bs.addBill(bill);
		return ResponseEntity.ok(billing);
	}

	/*@ExceptionHandler
	public ResponseEntity<VegErrorResponse> handleException(VegBillingIdNotFoundException exception) {
		VegErrorResponse error = new VegErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}*/

	/**
	 * This below function is used to get all the bills and redirects to the billing
	 * service
	 */

	// ViewAllBill
	@GetMapping("/billing")
	public ResponseEntity  <List<BillingDetails>> findAllBills() {
		logger.info("Getting all Billing Details");
		List <BillingDetails> billing= bs.viewAllBills();
		return ResponseEntity.ok(billing);
	}

	/**
	 * This below function is used to get all bill by Id and redirects to the
	 * billing service
	 */

	// viewBill by Id
	@GetMapping("/billing/{id}")
	public ResponseEntity <BillingDetails> viewBill(@PathVariable("id") int billingId) {
		logger.info("Getting Billing Details From Database By id" + billingId);
		if (bs.viewBill(billingId) == null) {
		  throw new VegBillingIdNotFoundException("Bill not found with billing id " + billingId);}
		BillingDetails billing= bs.viewBill(billingId);
		return ResponseEntity.ok(billing);
		
	}

	/**
	 * This below function is used to delete a specific bill based on the given Id
	 * and redirects to the billing service
	 */

	// deleteBill By Id
	@DeleteMapping("/billing/{id}")
	public BillingDetails deleteById(@PathVariable("id") int billingId) {
		logger.info("Deleting Bill in database by id" + billingId);
		if (bs.viewBill(billingId) == null) {
			throw new VegBillingIdNotFoundException(" Cannot found the given billing id " + billingId);
		}
		return bs.deleteById(billingId);
	}

	/**
	 * This below function is used to update a specific bill based on the given Id
	 * and redirects to the billing service
	 */
	@PutMapping("/billing/update/{id}")
	public ResponseEntity <BillingDetails> updateBill(@PathVariable("id") int billingId,@Valid @RequestBody BillingDetails bill) {
		logger.info("Updating Bill By Id" + billingId, bill);
		if (bs.updateBill(billingId, bill) == null) {
			throw new VegBillingIdNotFoundException("Bill not found with billing id " + billingId);
		}
		BillingDetails billing= bs.updateBill(billingId,bill);
		return ResponseEntity.ok(billing);
	
	}
}