package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.vegetable.module.OrderDet;

@SpringBootTest
class OrderServiceTest {
	
	@Autowired
	IOrderService ordService;
	
	@Autowired
	IVegetableService vegService;

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
		}
	
	@Test
	//@Disabled
	public void testViewOrderById() {
		OrderDet orderById = ordService.viewOrder(201);
		System.out.println(orderById);	
		assertEquals("2020-08-01",orderById.getOrderDate());
		assertEquals("Delivered", orderById.getStatus());
	
	}
	@Test
	//@Disabled
	public void testupdateOrderDetails() {
		OrderDet orderById = ordService.viewOrder(202);
		orderById.setOrderDate("2020-08-10");
		orderById.setStatus("Ordered");
		OrderDet ordupdate = ordService.updateOrderDetails(orderById);
		assertEquals("2020-08-10",ordupdate.getOrderDate());
		assertEquals("Ordered", ordupdate.getStatus());
	}
	
	@Test
	//@Disabled
	void testviewOrderListByDate() {
		List<OrderDet> ordbyDate = ordService.viewOrderList("2020-08-01");
		System.out.println(ordbyDate);
		assertEquals(1,ordbyDate.size());
	}
	
	@Test
	//@Disabled
	void testviewOrderList() {
		List<OrderDet> ordbyCust = ordService.viewOrderList();
		assertEquals(6,ordbyCust.size());

	}

	@Test
	//@Disabled
	public void testCancelOrder() {
		OrderDet cancelorder = ordService.cancelOrder(205);
		assertEquals(205, cancelorder.getOrderNo());
	}
}

	