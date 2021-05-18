package com.cg.vegetable.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.cg.vegetable.module.Customer;
import com.cg.vegetable.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

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
		cus.setEmailId(customer.getEmailId());
		cus.setAddress(customer.getAddress());
		return custRepo.save(cus);
	}

	@Override
	public List<Customer> viewCustomerList(String location) {
		return custRepo.viewCustomerList(location);
	}

	@Override
	public Customer viewCustomerbyId(int customerId) {
		Optional<Customer> cust = custRepo.findById(customerId);
		if (!cust.isPresent()) {
			return null;
		}
		return cust.get();
	}

	@Override
	public Customer deleteCustomerbyId(int customerId) {
		Optional<Customer> cust = custRepo.findById(customerId);
		if (!cust.isPresent()) {
			return null;
		}
		custRepo.deleteById(customerId);
		return cust.get();
	}

}
