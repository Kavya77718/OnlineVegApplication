package com.cg.vegetable.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
public class CustomerController {

	@Autowired
	ICustomerService custService;

	// add
	@PostMapping("/customer")
	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		return custService.addCustomer(customer);
	}

	@GetMapping("/customer/id/{id}")
	public Customer viewCustomerbyId(@PathVariable("id") int customerId) {
		if (custService.viewCustomerbyId(customerId) == null) {
			throw new CustomerNotFoundException("Customer not found with this id" + customerId);
		}
		return custService.viewCustomerbyId(customerId);
	}

	// Update
	@PutMapping("/customer/{id}")
	public Customer updateCustomer(@PathVariable("id") int id, @Valid @RequestBody Customer customer1) {
		return custService.updateCustomer(customer1);
	}

	// delete Customer by id
	@DeleteMapping("/customer/id/{id}")
	public Customer deleteCustomerbyId(@PathVariable("id") int customerId) {
		if (custService.deleteCustomerbyId(customerId) == null) {
			throw new CustomerNotFoundException("Customer not found with this id" + customerId);
		}
		return custService.deleteCustomerbyId(customerId);
	}

	@GetMapping("/customerr/{location}")
	public List<Customer> viewCustomerList(@PathVariable("location") String location) {
		return custService.viewCustomerList(location);
	}

}
