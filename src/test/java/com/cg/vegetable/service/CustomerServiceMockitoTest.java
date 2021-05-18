package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
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

@Test
//@Disabled
void testAddCustomer() {
	Customer customer = new Customer(1,"Kavya", "886535214", "abcd@g.com");
	Mockito.when(custRep.save(customer)).thenReturn(customer);
	Customer persistedCust = custService.addCustomer(customer);
	assertEquals(1, persistedCust.getCustomerId());
}

@Test
//@Disabled
void testViewList() {
	Customer customer1 = new Customer(7, "Ad", "7890654", "ad@g.com");
	Customer customer2 = new Customer(8, "rian", "123456", "rian@g.com");
	Address address1 = new Address(7, 88, "el", "kk nagar", "chennai", "TN", "600088");
	Address address2 = new Address(8, 89, "el", "kk nagar", "chennai", "TN", "600088");
	customer1.setAddress(address1);
	customer2.setAddress(address2);
	List<Customer> customerList = new ArrayList<>();
	customerList.add(customer1);
	customerList.add(customer2);
	//Customer persistedCust = custService.viewCustomerList(customerList);
}

}
