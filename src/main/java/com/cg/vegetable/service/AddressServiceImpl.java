package com.cg.vegetable.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vegetable.module.Address;
import com.cg.vegetable.repository.IAddressRepository;

@Service
public class AddressServiceImpl implements IAddressService {

	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(AddressServiceImpl.class);

	/**
	 * AutoWiring the IBillingRepository class to call down the service
	 */
	@Autowired
	IAddressRepository addrRepo;

	/*
	 * This below function save is used to create new address and redirects to
	 * addrRepo.
	 */
	@Override
	public Address save(Address address) {
		logger.info("adding address");
		return addrRepo.save(address);
	}

	/*
	 * This below function findAddressById is used to get the address using id and
	 * redirects to addressRepo.
	 */
	@Override
	public Address findAddressById(int id) {
		logger.info("getting address by id");
		Optional<Address> address = addrRepo.findById(id);
		if (!address.isPresent()) {
			return null;
		}
		return address.get();
	}

	/*
	 * This below function findAllAddresses is used to get all the addresses and
	 * redirects to addressRepo.
	 */
	@Override
	public List<Address> findAllAddresses() {
		logger.info("getting list of address");
		return addrRepo.findAll();
	}

	/*
	 * This below function update is used to update the retrieved address and
	 * redirects to addressRepo.
	 */

	@Override
	public Address update(Address address, int id) {
		logger.info("Updating the address details");
		Optional<Address> addr = addrRepo.findById(id);
		if(!addr.isPresent()) {
			return null;
		}
		addr.get().setId(address.getId());
		addr.get().setFlatNo(address.getFlatNo());
		addr.get().setBuildingName(address.getBuildingName());
		addr.get().setArea(address.getArea());
		addr.get().setLocation(address.getLocation());
		addr.get().setState(address.getState());
		addr.get().setPincode(address.getPincode());
		return addrRepo.save(addr.get());
		
	}


	/*
	 * This below function deleteAddressById is used to delete the address and
	 * redirects to addressRepo.
	 */
	@Override
	public Address deleteAddressById(int id) {
		logger.info("delete address by id");
		Optional<Address> address = addrRepo.findById(id);
		if (!address.isPresent()) {
			return null;
		}
		addrRepo.delete(address.get());
		return address.get();
	}

}
