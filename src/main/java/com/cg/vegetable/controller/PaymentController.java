package com.cg.vegetable.controller;
import java.util.List;

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
import com.cg.vegetable.exception.PaymentNotFoundException;
import com.cg.vegetable.module.PaymentErrorResponse;
import com.cg.vegetable.module.Payments;
import com.cg.vegetable.service.IPaymentService;

@RestController
public class PaymentController {

	@Autowired
	IPaymentService payService;
	
	@ExceptionHandler
	public ResponseEntity<PaymentErrorResponse> handleException(PaymentNotFoundException exception){
		PaymentErrorResponse error = new PaymentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	//Adding payment
	@PostMapping("/payments") 
	public Payments addPayment(@RequestBody Payments payment) {
		return payService.addPayment(payment);
	}
	
	//Get payment by passing payment id
	@GetMapping("/payments/id/{id}")
	public Payments findPaymentById(@PathVariable("id") int paymentId) {
		if(payService.findPaymentById(paymentId) == null) {
			throw new PaymentNotFoundException("Payment not found with given paymentId: "+paymentId);
		}
		return payService.findPaymentById(paymentId);
	}
	
	//Get list of payments
	@GetMapping("/payments")
	public List<Payments> findAllPayments(){
		return payService.findAllPayments();
	}
	
	//Update payment details
	@PutMapping("/payments/{id}")
	 public Payments save(@PathVariable("id") int paymentId, @RequestBody Payments payment) {
		if(payService.save(payment)==null) {
			throw new PaymentNotFoundException("payment not found with order id "+paymentId);
		}
		return payService.save(payment);
	}
	
	//delete payment
	@DeleteMapping("/payments/{id}")
	public Payments deletePaymentById(@PathVariable("id") int paymentId) {
		if(payService.deletePaymentById(paymentId) == null) {
			throw new PaymentNotFoundException("Payment not found with given id: "+paymentId);
		}
		return payService.deletePaymentById(paymentId);
	}
	
	
}
