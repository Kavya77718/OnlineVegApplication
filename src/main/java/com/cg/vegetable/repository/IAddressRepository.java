package com.cg.vegetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.vegetable.module.Address;

public interface IAddressRepository extends JpaRepository<Address, Integer> {

	}
