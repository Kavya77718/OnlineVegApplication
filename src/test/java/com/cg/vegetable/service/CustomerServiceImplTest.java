package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.*;

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
	//Add Customer
	void testAddCustomer() {
		Customer customer1 = new Customer(1, "Kavya", "886535214", "abcd@g.com");
		Address address = new Address(1, 77, "home", "valasaravakkam", "chennai", "tamilnadu", "600087");
		customer1.setAddress(address);
		Customer persistedCust = custService.addCustomer(customer1);
		assertEquals(1, persistedCust.getCustomerId());
		assertEquals("chennai", persistedCust.getAddress().getLocation());
	}
				
	
	@Test
	@Disabled
	// view customer by id
	void testViewCustomerList() {
		List<Customer> cust1 = custService.viewCustomerList("chennai");
		assertEquals(1, cust1.size());
	}
	
	@Test
	@Disabled
	// Delete customer by id
	void testDeleteCustomerId() {
		Customer persistedCust = custService.deleteCustomerbyId(2);
		assertEquals("Kavya",persistedCust.getName());
	}

	@Test
	@Disabled
	// update customer by id
	void testUpdateCustomer() {
		Customer customer1 = new Customer();
		customer1.setCustomerId(1);
		customer1.setName("Shriya");
		customer1.setMobileNumber("852963741");
		customer1.setEmailId("abcd@gmail.com");
		Address address = new Address(1, 89, "el", "kk nagar", "chennai", "TN", "600088");
		customer1.setAddress(address);
		Customer persistedCust = custService.updateCustomer(customer1);
		assertEquals(1, persistedCust.getCustomerId());
		assertEquals("Shriya", persistedCust.getName());
	}

}