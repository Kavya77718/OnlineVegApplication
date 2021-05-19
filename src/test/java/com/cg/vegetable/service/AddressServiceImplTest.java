package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vegetable.module.Address;

@SpringBootTest
public class AddressServiceImplTest {	
	@Autowired
	IAddressService addrService;

	@Test
	@Disabled
	// add customer
	void testAddCustomer() {
		Address address = new Address(4, 7, "aj", "kk road", "Bangalore", "TN", "98");
		Address persistedCust = addrService.save(address);
		assertEquals("kk road",persistedCust.getArea());
	}

	@Test
	@Disabled
	// delete customer by id
	void testDeleteAddressId() {
		Address addr = addrService.deleteAddressById(4);
		assertEquals(4, addr.getId());
	}
	
	@Test
	@Disabled
	//find list of addresses
	void testFindAllAddress() {
		List<Address> addr=addrService.findAllAddresses();
		assertEquals(1, addr.size());
	}
	
	@Test
	@Disabled
	// view address by id
	void testViewAddressbyId() {
		Address addr=addrService.findAddressById(10);
		System.out.println(addr);
		assertEquals("nelk", addr.getArea());
	}
	
	@Test
	@Disabled
	//update address
	void testUpdateAddress() {
		Address address=new Address();
		address.setId(10);
		address.setLocation("madurai");
		Address addr=addrService.update(address);
		assertEquals("madurai",addr.getLocation());
	}	
	
}

