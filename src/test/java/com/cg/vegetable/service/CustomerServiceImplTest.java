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
		Customer customer1 = new Customer(2,"Kavya", "886535214", "abcd@g.com");
		Address address = new Address(2, 77, "home", "valasaravakkam", "chennai", "tamilnadu", "600087");
		customer1.setAddress(address);
		Customer persistedCust =  custService.addCustomer(customer1);
		assertEquals(2, persistedCust.getCustomerId());
		assertEquals("chennai", persistedCust.getAddress().getLocation());
    }
		
	@Test
	@Disabled
	void testViewCustomerbyId() {
		Customer cust=new Customer();
		cust.setCustomerId(1);
		Customer persistedCust=custService.viewCustomerbyId(1);
		System.out.println(persistedCust);
		assertEquals("Kavya",persistedCust.getName());
	}
		
	@Test
	@Disabled
	void testDeleteCustomerId() {
		Customer persistedCust = custService.deleteCustomerbyId(2);
		assertEquals("Kavya",persistedCust.getName());
	}
	
	@Test
	@Disabled
	void testUpdateCustomer() {
		Customer customer1 = new Customer();
		customer1.setCustomerId(1);
		customer1.setName("Shriya");
		customer1.setMobileNumber("852963741");
		customer1.setEmailId("abcd@gmail.com");
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
		assertEquals(1, cust1.size());
	}
	
	
}