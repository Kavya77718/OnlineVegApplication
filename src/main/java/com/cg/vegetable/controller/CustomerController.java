package com.cg.vegetable.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vegetable.exception.CustomerNotFoundException;
import com.cg.vegetable.module.Customer;
import com.cg.vegetable.service.ICustomerService;

@CrossOrigin
@RestController
public class CustomerController {

	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(CustomerController.class);

	/**
	 * We are autowiring the customer service layer to this controller layer of
	 * customer
	 * 
	 * @param customerServiceImpl
	 */
	@Autowired
	ICustomerService custService;

	/**
	 * This controller is used to create a new or add new customer and redirects it
	 * to the service layer
	 * 
	 * @param
	 * @return
	 */
	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) {
		logger.info("adding customer");
		Customer cust = custService.addCustomer(customer);
		return ResponseEntity.ok(cust);
	}

	/**
	 * This controller is used to return and list all the customer found in the
	 * database and request to the service to perform the action
	 * 
	 * @return
	 */
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> findAllCustomer() {
		logger.info("getting list of customer");
		List<Customer> cust = custService.findAllCustomer();
		return ResponseEntity.ok(cust);
	}

	/**
	 * This controller is used to get a specific customer on basis of ID
	 * 
	 * @param id
	 * @return
	 * @throws customerNotFoundException
	 */
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> viewCustomerbyId(@PathVariable("id") int customerId) {
		logger.info("getting customer by id");
		if (custService.viewCustomerbyId(customerId) == null) {
			throw new CustomerNotFoundException("Customer not found with this id" + customerId);
		}
		Customer cust = custService.viewCustomerbyId(customerId);
		return ResponseEntity.ok(cust);
	}

	/**
	 * 
	 * this controller function perform deletion of a specific given customer and
	 * request the service to perform the action and returns the message as deleted
	 * else throw exception
	 * 
	 * @param customerid
	 * @return
	 * @throws CustomerNotFoundException
	 */
	@DeleteMapping("/customer/{id}")
	public Customer deleteCustomerbyId(@PathVariable("id") int customerId) {
		logger.info("deleting customer by id");
		if (custService.deleteCustomerbyId(customerId) == null) {
			throw new CustomerNotFoundException("Customer not found with this id" + customerId);
		}
		return custService.deleteCustomerbyId(customerId);
	}

	/**
	 * This function is used to update a specific customer on basis of given
	 * customer id and returns exception if given customer id is not found.
	 * 
	 * @param id
	 * @param customer
	 * @return
	 * @throws CustomerNotFoundException
	 */
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int customerId,
			@Valid @RequestBody Customer customer1) {
		logger.info("update customer by id");
		Customer cust = custService.updateCustomer(customer1, customerId);
		return ResponseEntity.ok(cust);
	}

	/**
	 * This controller is used to get all customer on basis of location
	 * 
	 * @param location
	 * @return
	 */
	@GetMapping("/customerr/{location}")
	public ResponseEntity<List<Customer>> viewCustomerList(@PathVariable("location") String location) {
		logger.info("getting list of customers by passing location");
		List<Customer> cust = custService.viewCustomerList(location);
		return ResponseEntity.ok(cust);

	}
	
	@GetMapping("/customer/name/{name}")
	public ResponseEntity<List<Customer>> findAllByName(@PathVariable("name") String name){
		List<Customer> cust = custService.findAllByName(name);
		return ResponseEntity.ok(cust);
	}
	

}
