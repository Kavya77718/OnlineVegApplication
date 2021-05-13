package com.cg.vegetable.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vegetable.module.Address;
import com.cg.vegetable.repository.IAddressRepository;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	IAddressRepository addrRepo;

	@Override
	public Address findAddressById(int id) {
		Optional<Address> address = addrRepo.findById(id);
		if(!address.isPresent()) {
			return null;
		}
		return address.get();
	}

	@Override
	public List<Address> findAllAddresses() {
		return addrRepo.findAll();
	}

	@Override
	public Address save(Address address) {
		return addrRepo.save(address);
	}

	@Override
	public Address update(Address address) {
		Optional<Address> addr = addrRepo.findById(address.getId());
		if(!addr.isPresent()) {
			return null;
		}
		
		addr.get().setId(address.getId());
		addr.get().setArea(address.getArea());
		addr.get().setLocation(address.getLocation());
			
		return addrRepo.save(addr.get());
	}

	@Override
	public Address deleteAddressById(int id) {
		Optional<Address> address = addrRepo.findById(id);
		if(!address.isPresent()) {
			return null;
		}
		addrRepo.delete(address.get());
		return address.get();
	}
}


