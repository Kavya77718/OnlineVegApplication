package com.cg.vegetable.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.vegetable.module.Feedback;

@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, Integer > {


	@Query(value = "select * from feedback inner join customer on feedback.customer_id = customer.customer_id where customer.customer_id =:i", nativeQuery = true)
	List<Feedback> viewFeedback(@Param("i") int customerId);
}
