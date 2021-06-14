package com.cg.vegetable.service;

import java.util.List;

import com.cg.vegetable.module.Address;

public interface IAddressService {

	Address findAddressById(int id);
	List<Address> findAllAddresses();
	Address save(Address address);
	Address update(Address address, int id);
	Address deleteAddressById(int id);
}