package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.vegetable.module.Address;
import com.cg.vegetable.module.Customer;
import com.cg.vegetable.repository.ICustomerRepository;

@ExtendWith(SpringExtension.class)
public class CustomerServiceMockitoTest {

	@InjectMocks
	CustomerServiceImpl custService;

	@MockBean
	ICustomerRepository custRep;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	/**
	 * This below function is Mockito test case used to test the testAddCustomer and to check whether it adds customer to the database
	 */
	@Test
    @Disabled
	void testAddCustomer() {
		Customer customer = new Customer( "Kavya", "886535214", "abcd@g.com","xxx12");
		Mockito.when(custRep.save(customer)).thenReturn(customer);
		Customer persistedCust = custService.addCustomer(customer);
		assertEquals(1, persistedCust.getCustomerId());
	}

	/**
	 * This below function is Mockito test case used to test the testFindAllCustomer and to check whether it retrieves all customer 
	 * from the database
	 */
	@Test
    //@Disabled
	void testViewList() {
		Customer customer1 = new Customer( "Ad", "7890654", "ad@g.com","yyy12");
		Customer customer2 = new Customer( "rian", "123456", "rian@g.com","str12");
		Address address1 = new Address(7, 88, "el", "kk nagar", "chennai", "TN", "600088");
		Address address2 = new Address(8, 89, "el", "kk nagar", "chennai", "TN", "600088");
		List<Address> addrList = new ArrayList<>();
		addrList.add(address1);
		addrList.add(address2);
		customer1.setAddress(addrList);
		List<Customer> customerList = new ArrayList<>();
		customerList.add(customer1);
		customerList.add(customer2);
		Mockito.when(custRep.viewCustomerList("chennai")).thenReturn(customerList);
		List<Customer> persistedCust = custService.viewCustomerList("chennai");
	}

	/**
	 * This below function is Mockito test case used to test the testDeleteCustomerById and to check whether it deletes customer by id
	 *  from the database
	 */
	@Test
    //@Disabled
	void testDeleteCustomerbyId() {
		Customer customer = new Customer( "tommy", "951771122", "tom@gmail.com","str13");
		Mockito.when(custRep.findById(1)).thenReturn(Optional.of(customer));
		custRep.deleteById(1);
		Customer persistedCust = custService.deleteCustomerbyId(1);
		assertEquals(1, persistedCust.getCustomerId());
		assertEquals("tommy", persistedCust.getName());
	}

	/**
	 * This below function is Mockito test case used to test the testViewCustomerById and to check whether it retrieves customer by id
	 * from the database
	 */
	@Test
    //@Disabled
	void testViewCustomerbyId() {
		Customer customer = new Customer( "jen", "951771122", "tom@gmail.com","str14");
		Mockito.when(custRep.findById(1)).thenReturn(Optional.of(customer));
		Customer persistedCust = custService.viewCustomerbyId(1);
		assertEquals("jen", persistedCust.getName());
	}

	/**
	 * This below function is Mockito test case used to test the testUpdateCustomer and to check whether it updates customer to the database
	 */
	@Test
	// @Disabled
	void testUpdateCustomer() {
		Customer customer1 = new Customer("minion", "951771122", "tom@gmail.com","str15");
		Mockito.when(custRep.findById(1)).thenReturn(Optional.of(customer1));
		Mockito.when(custRep.save(customer1)).thenReturn(customer1);
		Customer persistedCust = custService.updateCustomer(customer1, 1);
		assertEquals(1, persistedCust.getCustomerId());
	}
	
	/**
	 * Mockito test case for the method getting all the customers
	 */
	@Test
	// @Disabled
	void testViewAllCustomers() {
		Customer customer1 = new Customer("son", "951771122", "tom@gmail.com","str16");
		Customer customer2 = new Customer("lee", "951998122", "jerry@gmail.com","str17");
		List<Customer> customerList = new ArrayList<>();
		customerList.add(customer1);
		customerList.add(customer2);
		Mockito.when(custRep.findAll()).thenReturn(customerList);
		List<Customer> customer = custService.findAllCustomer();
		assertEquals(2, customer.size());
	}

}
