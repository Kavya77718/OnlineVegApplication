package com.cg.vegetable.service;


	import com.cg.vegetable.module.Customer;
	import com.cg.vegetable.module.CustomerLogin;

	public interface ICustomerLoginService {
		// Method to be override by the implementing class
		public Customer login(CustomerLogin user);

		// Method to be override by the implementing class
		public String logout(String emailId);
		
		public Customer getUser(String emailId);
	}

