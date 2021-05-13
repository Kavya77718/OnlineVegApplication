package com.cg.vegetable.service;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vegetable.module.Address;
import com.cg.vegetable.module.Customer;

@SpringBootTest
public class CustomerServiceImplTest {
	
	@Autowired
	ICustomerService custService;
	
	@Test
	@Disabled
	void  testAddCustomer() {
		Customer customer1 = new Customer(1,"Kavya", "886535214", "abcd@g.com");
		Address address = new Address(1, 77, "home", "valasaravakkam", "chennai", "tamilnadu", "600087");
		customer1.setAddress(address);
		Customer persistedCust =  custService.addCustomer(customer1);
		assertEquals(1, persistedCust.getCustomerId());
		assertEquals("chennai", persistedCust.getAddress().getLocation());
    }
	
	@Test
	@Disabled
	void testViewCustomer() {
		Customer customer1 = new Customer(1);
		Customer persistedCust = custService.viewCustomer(customer1);
		assertEquals("Kavya", persistedCust.getName());
	}
	
	@Test
	@Disabled
	void testRemoveCustomer() {
		Customer customer1 = new Customer(1);
		Customer persistedCust =  custService.removeCustomer(customer1);
		assertEquals(1, persistedCust.getCustomerId());
		assertEquals("Monisha", persistedCust.getName());
	}
	
	@Test
	@Disabled
	void testUpdateCustomer() {
		Customer customer1 = new Customer();
		customer1.setCustomerId(1);
		customer1.setName("Shriya");
		customer1.setMobileNumber("852963741");
		customer1.setEmailid("abcd@gmail.com");
		Address address =  new Address(1, 89, "el", "kk nagar", "chennai", "TN", "600088");
		customer1.setAddress(address);
		Customer persistedCust = custService.updateCustomer(customer1);
		assertEquals(1, persistedCust.getCustomerId());
		assertEquals("Shriya", persistedCust.getName());
	}
	
	@Test
	@Disabled
	void testViewCustomerList() {
		List<Customer> cust1 = custService.viewCustomerList("chennai");
		assertEquals(0, cust1.size());
	}
	
	
}