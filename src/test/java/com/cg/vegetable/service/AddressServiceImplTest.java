package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vegetable.controller.AddressController;
import com.cg.vegetable.module.Address;

@SpringBootTest
public class AddressServiceImplTest {	
	
	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(AddressServiceImplTest.class);
	
	/**
	 * Autowiring the AddressServiceImplTest class to call down the service
	 */
	@Autowired
	IAddressService addrService;

	/**
	 * This below function is  Mockito test case used to test the testAddAddress and to check whether it adds Address to the database
	 */
	@Test
	@Disabled
	void testAddAddress() {
		logger.info("adding address");
		Address address = new Address(4, 7, "aj", "kk road", "Bangalore", "TN", "98");
		Address persistedCust = addrService.save(address);
		assertEquals("kk road",persistedCust.getArea());
	}

	/**
	 * This below function is Mockito test case used to test the testDeleteAddressId and to check whether it deletes address by id
	 *  from the database
	 */
	@Test
	@Disabled
	void testDeleteAddressId() {
		logger.info("delete address by id");
		Address addr = addrService.deleteAddressById(4);
		assertEquals(4, addr.getId());
	}
	
	/**
	 * This below function is Mockito test case used to test the testFindAllAddress and to check whether it retrieves all address 
	 * from the database
	 */
	@Test
	@Disabled
	void testFindAllAddress() {
		logger.info("getting list of address");
		List<Address> addr=addrService.findAllAddresses();
		assertEquals(1, addr.size());
	}
	
	/**
	 * This below function is Mockito test case used to test the testViewAddressbyId and to check whether it retrieves address by id
	 * from the database
	 */
	@Test
	@Disabled
	void testViewAddressbyId() {
		logger.info("getting address by id");
		Address addr=addrService.findAddressById(10);
		System.out.println(addr);
		assertEquals("nelk", addr.getArea());
	}
	
	/**
	 * This below function is  Mockito test case used to test the testUpdateAddress and to check whether it updates address to the database
	 */
	@Test
	@Disabled
	void testUpdateAddress() {
		logger.info("update address by id");
		Address address=new Address();
		address.setId(10);
		address.setLocation("madurai");
		Address addr=addrService.update(address);
		assertEquals("madurai",addr.getLocation());
	}	
	
}

