package com.cg.vegetable.service;

import java.util.List;

import com.cg.vegetable.module.Customer;

public interface ICustomerService {
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer, int customerId);
	public List<Customer> viewCustomerList(String location);
	public Customer viewCustomerbyId(int customerId);
	public Customer deleteCustomerbyId(int customerId);
	public List<Customer> findAllCustomer();
	public List<Customer> findAllByName(String name);
	public Customer findCustomerByEmailId(String emailId);

}
