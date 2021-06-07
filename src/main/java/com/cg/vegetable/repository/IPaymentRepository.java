package com.cg.vegetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.vegetable.module.Payments;

@Repository
public interface IPaymentRepository extends JpaRepository<Payments, Long>{

	
}