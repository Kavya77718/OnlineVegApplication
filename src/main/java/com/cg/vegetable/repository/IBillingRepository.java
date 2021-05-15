package com.cg.vegetable.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.vegetable.module.BillingDetails;


@Repository
public interface IBillingRepository extends JpaRepository<BillingDetails,Integer> {

	//Optional<BillingDetails> findById();

}
