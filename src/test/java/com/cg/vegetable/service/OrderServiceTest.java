package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.vegetable.module.OrderDet;

@SpringBootTest
class OrderServiceTest {
	
	//Logger
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(OrderServiceTest.class);
		
	//AutoWiring the OrderService class to call down the service
	@Autowired
	IOrderService ordService;
	
	@Autowired
	IVegetableService vegService;

	// Testing whether the new order is adding to the database or not
	@Test
	//@Disabled
	void testAddOrder() {
		OrderDet orderdet = new OrderDet(); 
		orderdet.setOrderNo(1);
		orderdet.setOrderDate("2020-08-09");
		orderdet.setTotalAmount(100.00);
		orderdet.setStatus("Delivered");
		
		OrderDet persistedOrd = ordService.addOrder(orderdet);
		assertEquals(1,persistedOrd.getOrderNo());
		assertEquals("2020-08-09",persistedOrd.getOrderDate());
		assertEquals(100.00,persistedOrd.getTotalAmount());
		assertEquals("Delivered",persistedOrd.getStatus());
		logger.info(orderdet);
		logger.info("Added order successfully");
		}
	
	// Testing whether the given id fetches the given order or not.
	@Test
	//@Disabled
	public void testViewOrderById() {
		OrderDet orderById = ordService.viewOrder(201);
		System.out.println(orderById);	
		assertEquals("2020-08-01",orderById.getOrderDate());
		assertEquals("Delivered", orderById.getStatus());
		logger.info(orderById);
		logger.info("Viewed order successfully");
	}
	
	// Testing whether the given id fetches the given order to update and whether it is updating the order
	@Test
	//@Disabled
	public void testupdateOrderDetails() {
		OrderDet orderById = ordService.viewOrder(202);
		orderById.setOrderDate("2020-08-10");
		orderById.setStatus("Ordered");
		OrderDet ordupdate = ordService.updateOrderDetails(orderById);
		assertEquals("2020-08-10",ordupdate.getOrderDate());
		assertEquals("Ordered", ordupdate.getStatus());
		logger.info(orderById);
		logger.info("Updated order successfully");
	}
	
	// Testing whether the given date fetches the list of orders or not.
	@Test
	//@Disabled
	void testviewOrderListByDate() {
		List<OrderDet> ordbyDate = ordService.viewOrderList("2020-08-01");
		System.out.println(ordbyDate);
		assertEquals(1,ordbyDate.size());
		logger.info(ordbyDate);
		logger.info("fetching list of orders by date successfully");
	}
	
	// Testing whether the given id fetches the given order or not
	@Test
	//@Disabled
	void testviewOrderList() {
		List<OrderDet> ordbyCust = ordService.viewOrderList();
		assertEquals(6,ordbyCust.size());
		logger.info(ordbyCust);
		logger.info("fetching list of orders by customer id successfully");
	}

	// Testing whether the given id fetches and deleted the given order or not
	@Test
	//Disabled
	public void testCancelOrder() {
		OrderDet cancelorder = ordService.cancelOrder(202);
		assertEquals(202, cancelorder.getOrderNo());
		logger.info(cancelorder);
		logger.info("deleted date successfully");
	}
}

	