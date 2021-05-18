package com.cg.vegetable.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.vegetable.module.Customer;
import com.cg.vegetable.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	ICustomerRepository custRepo;

	@Override
	public Customer addCustomer(Customer customer) {
		return custRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer cus = custRepo.findById(customer.getCustomerId()).get();
	    cus.setName(customer.getName());
	    cus.setMobileNumber(customer.getMobileNumber());
		cus.setEmailid(customer.getEmailId());
		cus.setAddress(customer.getAddress());
		return custRepo.save(cus);
	}

	@Override
	public Customer removeCustomer(Customer customer) {
		Customer cus = custRepo.findById(customer.getCustomerId()).get();
		custRepo.deleteById(customer.getCustomerId());
		return cus;
	}

	@Override
	public Customer viewCustomer(Customer customer) {
		Optional<Customer> cus = custRepo.findById(customer.getCustomerId());
		if(!cus.isPresent()) {
			return null;
		}
		return cus.get();
	}

	@Override
	public List<Customer> viewCustomerList(String location) {
		return custRepo.viewCustomerList(location);
	}



}
