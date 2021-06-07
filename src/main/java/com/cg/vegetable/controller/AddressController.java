package com.cg.vegetable.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vegetable.exception.AddressNotFoundException;
import com.cg.vegetable.exception.CustomerNotFoundException;
import com.cg.vegetable.module.Address;
import com.cg.vegetable.service.IAddressService;

@CrossOrigin
@RestController
public class AddressController {

	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(AddressController.class);

	/**
	 * We are autowiring the address service layer to this controller layer of
	 * address
	 * 
	 * @param addressServiceImpl
	 */
	@Autowired
	IAddressService addrService;

	// private static final string E

	/**
	 * This controller is used to create a new or add new address and redirects it
	 * to the service layer
	 * 
	 * @param
	 * @return
	 */
	@PostMapping("/address")
	public ResponseEntity<Address> save(@Valid @RequestBody Address address) {
		logger.info("adding address");
		Address addr = addrService.save(address);
		return ResponseEntity.ok(addr);
	}

	/**
	 * This controller is used to get a specific address on basis of ID
	 * 
	 * @param id
	 * @return
	 * @throws addressNotFoundException
	 */
	@GetMapping("/address/{id}")
	public ResponseEntity<Address> findAddressById(@PathVariable("id") int id) {
		logger.info("getting address by id");
		if (addrService.findAddressById(id) == null) {
			throw new AddressNotFoundException("Address not found with this id " + id);
		}
		Address addr = addrService.findAddressById(id);
		return ResponseEntity.ok(addr);
	}

	/**
	 * 
	 * this controller function perform deletion of a specific given address and
	 * request the service to perform the action and returns the message as deleted
	 * else throw exception
	 * 
	 * @param id
	 * @return
	 * @throws AddressNotFoundException
	 */
	@DeleteMapping("/address/{id}")
	public Address deleteAddressById(@PathVariable("id") int id) {
		logger.info("delete address by id");
		if (addrService.deleteAddressById(id) == null) {
			throw new AddressNotFoundException("Address not found with this id" + id);
		}
		return addrService.deleteAddressById(id);

	}

	/**
	 * This controller is used to return and list all the address found in the
	 * database and request to the service to perform the action
	 * 
	 * @return
	 */
	@GetMapping("/address")
	public ResponseEntity<List<Address>> findAllAddresses() {
		logger.info("getting all list of address");
		List<Address> addr = addrService.findAllAddresses();
		return ResponseEntity.ok(addr);
	}

	/**
	 * This function is used to update a specific address on basis of given address
	 * id and returns exception if given customer id is not found.
	 * 
	 * @param id
	 * @param address
	 * @return
	 * @throws AddressNotFoundException
	 */
	@PutMapping("/address")
	public ResponseEntity<Address> update(@RequestBody Address address) {
		logger.info("delete address by id");
		if (addrService.update(address) == null) {
			throw new AddressNotFoundException("AddressId Not Found:" + address.getId());
		}
		Address addr = addrService.update(address);
		return ResponseEntity.ok(addr);
	}

}