package com.cg.vegetable.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.vegetable.module.OrderDet;

@Repository
public interface IOrderRepository extends JpaRepository<OrderDet, Integer>{

	List<OrderDet> findAllOrdersByCustId(int custId);
	List<OrderDet> findAllOrdersByOrderDate(String orderDate);
		/*
		// Custom Queries
		
		// find order based on customer name
		@Query("select e from OrderDet e  where e.custid=:n")
		public OrderDet view(@Param("n") int custid);
		
		
		// find order based on Customer name and order no.
		@Query("select e from OrderDet e where e.custid=:n and e.orderid=:d")
		public List<OrderDet> viewOrderByCustIdAndOrderNo(@Param("d") int custid, @Param("n") int orderid);
	    
		// find order based on order no. and date
		@Query(value="select * from OrderDet where orderid=:n or date=:d", nativeQuery=true)
		public List<OrderDet> viewOrderByOrderNoOrDate(@Param("d") int orderid, @Param("n") String date);
	    
		*/
		
		
}
