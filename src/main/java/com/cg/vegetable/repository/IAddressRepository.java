package com.cg.vegetable.repository;

/**
 * User Repository interface extends
 * {@link org.springframework.data.jpa.repository.JpaRepository}.
 */
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.vegetable.module.Address;

public interface IAddressRepository extends JpaRepository<Address, Integer> {

	}
