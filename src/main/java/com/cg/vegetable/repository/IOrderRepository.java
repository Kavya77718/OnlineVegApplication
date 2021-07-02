package com.cg.vegetable.repository;


import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.vegetable.module.Customer;
import com.cg.vegetable.module.OrderDet;

@Repository
public interface IOrderRepository extends JpaRepository<OrderDet, Integer>{

	//List<OrderDet> findAllOrdersByCustomerId(int customerId);
	List<OrderDet> findAllOrdersByOrderDate(LocalDate orderDate);
		
	@Query(value = "select * from order inner join customer on OrderDet.customer_id = customer.customer_id where customer.customer_id=:l", nativeQuery = true)
	List<OrderDet> viewOrderList(@Param("l") int customerId);
}