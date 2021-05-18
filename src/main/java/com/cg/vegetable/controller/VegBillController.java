package com.cg.vegetable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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




@RestController
public class VegBillController {
	@ExceptionHandler
	public ResponseEntity<VegErrorResponse> handleException(VegBillingIdNotFoundException exception){
	VegErrorResponse error=new VegErrorResponse();
	error.setStatus(HttpStatus.NOT_FOUND.value());
	error.setMessage(exception.getMessage());
	error.setTimeStamp(System.currentTimeMillis());
	return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);//
	}
	@Autowired
	IBillingService bs;
	
	@GetMapping("/billing/{id}")
	public  BillingDetails viewBill(@PathVariable("id") int billingId) {
		if( bs.viewBill(billingId)==null) {
			throw new VegBillingIdNotFoundException("Bill not found with billing id "+billingId);
		}
		return bs.viewBill(billingId);
	}
	
	
	@PostMapping("/billing")
	public BillingDetails addBill(@RequestBody BillingDetails bill) {	
		return bs.addBill(bill);
	}

	
	@DeleteMapping("/billing/{id}")
	public  BillingDetails deleteById(@PathVariable("id") int billingId) {
		if( bs.viewBill(billingId)==null) {
			throw new VegBillingIdNotFoundException (" Cannot found the given billing id "+billingId);
		}
		return bs.deleteById(billingId);
	}

	@PutMapping("/billing/{id}") 
	public BillingDetails updateBill(@PathVariable("id") int billingId, @RequestBody BillingDetails bill) {
		if( bs.updateBill(bill)==null) {
			throw new VegBillingIdNotFoundException("Bill not found with billing id "+billingId);
		}
		return bs.updateBill(bill);
	}
	}


	