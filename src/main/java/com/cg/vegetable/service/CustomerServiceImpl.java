package com.cg.vegetable.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vegetable.controller.CustomerController;
import com.cg.vegetable.module.Cart;
import com.cg.vegetable.module.Customer;
import com.cg.vegetable.repository.ICartRepository;
import com.cg.vegetable.repository.ICustomerRepository;
import com.cg.vegetable.repository.IVegetableRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(CustomerServiceImpl.class);

	/**
	 * Autowiring the ICustomerRepository class to call down the service
	 */
	@Autowired
	ICustomerRepository custRepo;
	
	@Autowired
	ICartRepository cartRepo;
	
	@Autowired
	ICartService cartServ;
	
	@Autowired
	IVegetableRepository vegrepo;

	/*
	 * This below function addCustomer is used to create new customer and redirects
	 * to custRepo.
	 */
	@Override
	public Customer addCustomer(Customer customer) {
		logger.info("adding customer");
		return custRepo.save(customer);
	}
	/*@Override
	public Customer addCustomer(Customer customer) {
		logger.info("adding customer");
	Optional<Customer> opt = Optional.ofNullable(custRepo.findCustomerByEmailId(customer.getEmailId()));
	if(opt.isPresent()) {
		return null;
	}
	Customer cust=custRepo.save(customer);
	int id= cust.getCustomerId();
	Cart cart=cartServ.addCartToCustomer(id);
	cartRepo.save(cart);
	return cust;
	}*/

	/*
	 * This below function findAllCustomer is used to get all the customers and
	 * redirects to custRepo.
	 */
	@Override
	public List<Customer> findAllCustomer() {
		logger.info("getting list of customer");
		return custRepo.findAll();
	}

	/*
	 * This below function viewCustomerbyId is used to get the customer using id and
	 * redirects to custRepo.
	 */
	@Override
	public Customer viewCustomerbyId(int customerId) {
		logger.info("getting customer by id");
		Optional<Customer> cust = custRepo.findById(customerId);
		if (!cust.isPresent()) {
			return null;
		}
		return cust.get();
	}

	/*
	 * This below function deleteCustomerbyId is used to delete the customer and
	 * redirects to custRepo.
	 */
	@Override
	public Customer deleteCustomerbyId(int customerId) {
		logger.info("deleting customer by id");
		Optional<Customer> cust = custRepo.findById(customerId);
		if (!cust.isPresent()) {
			return null;
		}
		custRepo.deleteById(customerId);
		return cust.get();
	}

	/*
	 * This below function findAllCustomer is used to get all the customers by
	 * location and redirects to custRepo.
	 */
	@Override
	public List<Customer> viewCustomerList(String location) {
		logger.info("getting list of customers by passing location");
		return custRepo.viewCustomerList(location);
	}

	/*
	 * This below function updateCustomer is used to update the retrieved customer
	 * and redirects to custRepo.
	 */
	@Override
	public Customer updateCustomer(Customer customer, int customerId) {
		logger.info("update customer by id");
		Customer cus = custRepo.findById(customerId).get();
		cus.setName(customer.getName());
		cus.setMobileNumber(customer.getMobileNumber());
		cus.setEmailId(customer.getEmailId());
		cus.setAddress(customer.getAddress());
		return custRepo.save(cus);
	}

	@Override
	public List<Customer> findAllByName(String name) {
		List<Customer> customerList = custRepo.findAllByName(name);
		if(customerList.isEmpty()) {
		return null;
		}
		
		logger.info(customerList);
		return custRepo.findAllByName(name);
	}

	@Override
	public Customer findCustomerByEmailId(String emailId) {
		return custRepo.findCustomerByEmailId(emailId);
	}

	
	}

	
