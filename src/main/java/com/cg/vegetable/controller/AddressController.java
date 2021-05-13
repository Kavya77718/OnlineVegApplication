package com.cg.vegetable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vegetable.exception.AddressNotFoundException;
import com.cg.vegetable.module.Address;
import com.cg.vegetable.service.IAddressService;

@RestController
public class AddressController {

	@Autowired
	IAddressService addrService;

	@GetMapping("/address/{id}")
	public Address findAddressById(@PathVariable("id") int id) {
		if (addrService.findAddressById(id) == null) {
			throw new AddressNotFoundException("Address not found with this id " + id);
		}
		return addrService.findAddressById(id);
	}

	@DeleteMapping("/address/{id}")
	public Address deleteAddressById(@PathVariable("id") int id) {
		if (addrService.deleteAddressById(id) == null) {
			throw new AddressNotFoundException("Address not found with this id" + id);
		}
		return addrService.deleteAddressById(id);
	}

	@GetMapping("/address")
	public List<Address> findAllAddresses() {
		return addrService.findAllAddresses();
	}

	@PostMapping("/address")
	public Address save(@RequestBody Address address) {
		return addrService.save(address);
	}

	@PutMapping("/address")
	public Address update(@RequestBody Address address) {
		if (addrService.update(address) == null) {
			throw new AddressNotFoundException("AddressId Not Found:" + address.getId());
		}
		return addrService.update(address);
	}

}