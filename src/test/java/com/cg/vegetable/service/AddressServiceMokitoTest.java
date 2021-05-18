package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.cg.vegetable.module.Address;
import com.cg.vegetable.repository.IAddressRepository;

@ExtendWith(SpringExtension.class)
public class AddressServiceMokitoTest {
	@InjectMocks
	AddressServiceImpl addrService;
	
	@MockBean
	IAddressRepository addrRep;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	//@Disabled
	void testAddAddress(){
		Address address=new Address(6, 9, "ak", "kk road", "Bangalore", "TN", "98");
		Mockito.when(addrRep.save(address)).thenReturn(address);
		Address address1=addrService.save(address);
		assertEquals(6,address1.getId());
	}
	

	@Test
	//@Disabled
	void testDeleteAddressById() {
		Address address=new Address(4, 7, "aj", "kk road", "Bangalore", "TN", "98");
		Mockito.when(addrRep.findById(4)).thenReturn(Optional.of(address));
		addrService.deleteAddressById(4);
		assertEquals(4,address.getId());
	}
	
	@Test 
	//@Disabled
	void testupdateAddress() {
		Address address=new Address(4, 7, "aj", "kk road", "Bangalore", "TN", "98");
		Mockito.when(addrRep.findById(4)).thenReturn(Optional.of(address));
		Mockito.when(addrRep.save(address)).thenReturn(address);
		Address address1=addrService.update(address);
		assertEquals("kk road",address1.getArea());
	}
	
	@Test
	//@Disabled
	void testViewAddress() {
		Address address1=new Address(4, 7, "aj", "kk road", "Bangalore", "TN", "98");
		Address address2=new Address(5, 7, "aj", "kk road", "chennai", "TN", "99");
		List<Address> addressList = new ArrayList<>();
		addressList.add(address1);
		addressList.add(address2);
		Mockito.when(addrRep.findAll()).thenReturn(addressList);
		List<Address> address = addrService.findAllAddresses();
		assertEquals(2, address.size());
	
	}
	
	@Test
	//@Disabled
	void testViewbyId() {
	Address address=new Address(4, 7, "aj", "kk road", "Bangalore", "TN", "98");
	Mockito.when(addrRep.findById(4)).thenReturn(Optional.of(address));
	assertEquals(4,address.getId());
}
	
}