package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vegetable.module.Address;
import com.cg.vegetable.module.Customer;

@SpringBootTest
public class CustomerServiceImplTest {	
	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(CustomerServiceImplTest.class);
	
	/**
	 * Autowiring the CustomerServiceImplTest class to call down the service
	 */
	@Autowired
	ICustomerService custService;
	
	/**
	 * This below function is used to test the testAddCustomer and to check whether it adds customer to the database
	 */
	@Test
	//@Disabled
	void  testAddCustomer() {
		logger.info("adding customer");
		Customer customer1 = new Customer("Kavya", "886535214", "abcd@g.com","xxx12");
		Address address = new Address(2, 77, "home", "valasaravakkam", "chennai", "tamilnadu", "600087");
		List<Address> addrList = new ArrayList<>();
		addrList.add(address);
		customer1.setAddress(addrList);
		Customer persistedCust =  custService.addCustomer(customer1);
		assertEquals(2, persistedCust.getCustomerId());
		assertEquals(1, persistedCust.getAddress().size());
    }
		
	/**
	 * This below function is used to test the testFindAllCustomer and to check whether it retrieves all customer 
	 * from the database
	 */
	@Test
	//@Disabled
	void testFindAllCustomer() {
		List<Customer> customer=custService.findAllCustomer();
		logger.info(customer);
		assertEquals(4, customer.size());
	}
	
	/**
	 * This below function is used to test the testViewCustomerById and to check whether it retrieves customer by id
	 * from the database
	 */

	@Test
	//@Disabled
	void testViewCustomerbyId() {
		logger.info("getting customer by id");
		Customer cust=new Customer();
		cust.setCustomerId(1);
		Customer persistedCust=custService.viewCustomerbyId(1);
		System.out.println(persistedCust);
		assertEquals("Kavya",persistedCust.getName());
	}

/*
	@Test
	//@Disabled
	void testRemoveCustomer() {
		Customer customer1 = new Customer(1);
		Customer persistedCust = custService.removeCustomer(customer1);
		assertEquals(1, persistedCust.getCustomerId());
		assertEquals("Monisha", persistedCust.getName());
	}
*/

	
	/**
	 * This below function is used to test the testDeleteCustomerById and to check whether it deletes customer by id
	 *  from the database
	 */
	@Test
	//@Disabled
	void testDeleteCustomerId() {
		logger.info("deleting customer by id");
		Customer persistedCust = custService.deleteCustomerbyId(2);
		assertEquals("Kavya",persistedCust.getName());
	}
	
	
	/**
	 * This below function is used to test the testUpdateCustomer and to check whether it updates customer to the database
	 */

	@Test
	//@Disabled
	void testUpdateCustomer() {
		logger.info("update customer by id");
		Customer customer1 = new Customer();
		customer1.setCustomerId(1);
		customer1.setName("Shriya");
		customer1.setMobileNumber("852963741");
		customer1.setEmailId("abcd@gmail.com");
		Address address =  new Address(1, 89, "el", "kk nagar", "chennai", "TN", "600088");
		List<Address> addrList = new ArrayList<>();
		addrList.add(address);
		customer1.setAddress(addrList);
		Customer persistedCust = custService.updateCustomer(customer1, 1);
		assertEquals(1, persistedCust.getCustomerId());
		assertEquals("Shriya", persistedCust.getName());
	}
	
	/**
	 * This below function is used to test the testViewCustomerList and to check whether it retrieves all customers by location
	 * from the database
	 */
  @Test
	//@Disabled
	void testViewCustomerList() {
		logger.info("getting list of customers by passing location");
		List<Customer> cust1 = custService.viewCustomerList("chennai");
		assertEquals(1, cust1.size());
	}

}