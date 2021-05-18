package com.cg.vegetable.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.vegetable.module.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(value = "select * from customer inner join address on customer.address_id = address.id where address.location =:l", nativeQuery = true)
	List<Customer> viewCustomerList(@Param("l") String location);

}