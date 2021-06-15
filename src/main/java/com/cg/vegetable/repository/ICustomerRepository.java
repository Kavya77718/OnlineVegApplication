package com.cg.vegetable.repository;


/**
 * User Repository interface extends
 * {@link org.springframework.data.jpa.repository.JpaRepository}.
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.vegetable.module.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(value = "select * from address inner join customer on address.cust_id = customer.customer_id where address.location =:l", nativeQuery = true)
	List<Customer> viewCustomerList(@Param("l") String location);
	Customer findCustomerByEmailId(String email);
	List<Customer> findAllByName(String name);
}