package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set; 
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vegetable.module.OrderDet;
import com.cg.vegetable.module.Vegetable;


@SpringBootTest
class OrderServiceTest {
	
	@Autowired
	IOrderService ordService;
	
	@Autowired
	IVegetableService vegService;

	@Test
	@Disabled
	void testAddOrder() {
		OrderDet orderdet = new OrderDet(); 
		Vegetable vegdto1 = new Vegetable(7,"Carrot","Vegetable","A",50.00,1);
		Vegetable vegdto2 = new Vegetable(8,"BeetRoot","Vegetable","A",50.00,1);
		Vegetable vegie =vegService.save(vegdto2);
		orderdet.setOrderNo(1);
		orderdet.setCustId(126);
		orderdet.setOrderDate("2020-08-09");
		orderdet.setTotalAmount(100.00);
		orderdet.setStatus("Delivered");
		
		List VegList = Stream.of(vegdto1, vegdto2).collect(Collectors.toList());
		orderdet.setVegList(VegList);
		
		OrderDet persistedOrd = ordService.addOrder(orderdet);
		assertEquals(1,persistedOrd.getOrderNo());
		assertEquals(126,persistedOrd.getCustId());
		assertEquals("2020-08-09",persistedOrd.getOrderDate());
		assertEquals(100.00,persistedOrd.getTotalAmount());
		assertEquals("Delivered",persistedOrd.getStatus());
		//assertEquals(7,vegie.getVegId());
		//assertEquals("Carrot",vegie.getName());
		assertEquals(8,vegie.getVegId());
		assertEquals("BeetRoot",vegie.getName());
		
			}
	@Test
	@Disabled
	public void testViewOrderById() {
		OrderDet orderById = ordService.viewOrder(6);
		System.out.println(orderById);
		
		assertEquals("2020-08-09",orderById.getOrderDate());
		assertEquals("Delivered", orderById.getStatus());
	
	}
	@Test
	@Disabled
	public void testupdateOrderDetails() {
		OrderDet orderById = ordService.viewOrder(6);
		orderById.setOrderDate("2020-08-09");
		orderById.setStatus("Delivered");
		
		OrderDet ordupdate = ordService.updateOrderDetails(orderById);
		
		assertEquals("2020-08-09",ordupdate.getOrderDate());
		assertEquals("Delivered", ordupdate.getStatus());
	}
	
	
	@Test
	@Disabled
	void testviewAllOrdersByCustId() {
		List<OrderDet> ordbyCust = ordService.viewAllOrders(127);
		System.out.println(ordbyCust);
		assertEquals(2,ordbyCust.size());	
	}
	
	@Test
	@Disabled
	void testviewOrderListByDate() {
		List<OrderDet> ordbyCust = ordService.viewOrderList("2020-08-09");
		System.out.println(ordbyCust);
		assertEquals(3,ordbyCust.size());
	}

	@Test
	@Disabled
	void testviewOrderList() {
		List<OrderDet> ordbyCust = ordService.viewOrderList();
		assertEquals(5,ordbyCust.size());

	}

	@Test
	@Disabled
	public void testCancelOrder() {
		OrderDet cancelorder = ordService.cancelOrder(9);
		assertEquals(9, cancelorder.getOrderNo());
	}
}

	