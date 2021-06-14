package com.cg.vegetable.controller;
import java.util.List;

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
import com.cg.vegetable.exception.PaymentNotFoundException;
import com.cg.vegetable.module.PaymentErrorResponse;
import com.cg.vegetable.module.Payments;
import com.cg.vegetable.service.IPaymentService;
@CrossOrigin
@RestController
public class PaymentController {
	//Logger
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(PaymentController.class);
			
	//AutoWiring the PaymentService class to call down the service
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
	
	//Using Post Mapping for Adding payment into database
	@PostMapping("/payments") 
	public ResponseEntity<Payments> addPayment(@RequestBody Payments payment) {
		logger.info("Adding payment details to the database");
		Payments addpay = payService.addPayment(payment);
		return ResponseEntity.ok(addpay);
	}
	
	//Get payment by passing payment id
	@GetMapping("/payments/id/{id}")
	public ResponseEntity<Payments> findPaymentById(@PathVariable("id") int paymentId) {
		logger.info("finding payment by id from the database");
		if(payService.findPaymentById(paymentId) == null) {
			throw new PaymentNotFoundException("Payment not found with given paymentId: "+paymentId);
		}
		Payments findpay = payService.findPaymentById(paymentId);
		return ResponseEntity.ok(findpay);
	}
	
	//using Get Mapping for Getting list of payments
	@GetMapping("/payments")
	public ResponseEntity<List<Payments>> findAllPayments(){
		logger.info("finding all payments from the database");
		List<Payments> Listpay = payService.findAllPayments();
		return ResponseEntity.ok(Listpay);
	}
	
	//using Put Mapping for Updating payment details
	@PutMapping("/payments/{id}")
	 public ResponseEntity<Payments> save(@PathVariable("id") int paymentId, @RequestBody Payments payment) {
		logger.info("saving or updating payment from the database");
		if(payService.save(payment)==null) {
			throw new PaymentNotFoundException("payment not found with order id "+paymentId);
		}
		Payments savePay = payService.save(payment);
		return ResponseEntity.ok(savePay);
	}
	
	//using Delete Mapping to delete payment
	@DeleteMapping("/payments/{id}")
	public Payments deletePaymentById(@PathVariable("id") int paymentId) {
		logger.info("deleting payment by id from the database");
		if(payService.deletePaymentById(paymentId) == null) {
			throw new PaymentNotFoundException("Payment not found with given id: "+paymentId);
		}
		return payService.deletePaymentById(paymentId);
	}
	
	
}

