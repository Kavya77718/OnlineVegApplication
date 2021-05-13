package com.cg.vegetable.controller;

import java.util.List;

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
	public Customer addCustomer(@RequestBody Customer customer) {
		return custService.addCustomer(customer);
	}

	/*// view
	@GetMapping("/customer/{id}")
	public Customer viewCustomer(@PathVariable("id") Customer customer) {
		return custService.viewCustomer(customer);
	}*/
	
	@GetMapping("/customer/{id}")
	public Customer viewCustomer(@PathVariable("id") Customer customer) {
		if(custService.viewCustomer(customer) == null) {
			throw new CustomerNotFoundException("Employee not found with given id: "+customer.getCustomerId());
		}
		return custService.viewCustomer(customer);
	}

	// Update
	@PutMapping("/customer/{id}")
	public Customer updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer1) {
		return custService.updateCustomer(customer1);
	}

	// Delete
	@DeleteMapping("/customer/{id}")
	public Customer removeCustomer(@PathVariable("id") Customer customer) {
		return custService.removeCustomer(customer);
	}
	
	@GetMapping("/customerr/{location}")
	public List<Customer> viewCustomerList(@PathVariable("location") String location) {
		return custService.viewCustomerList(location);
	}

}

