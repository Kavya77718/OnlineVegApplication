package com.cg.vegetable.service;

import java.util.List;

import com.cg.vegetable.module.Customer;

public interface ICustomerService {
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer removeCustomer(Customer customer);
	public Customer viewCustomer(Customer customer);
	public List<Customer> viewCustomerList(String location);

}
