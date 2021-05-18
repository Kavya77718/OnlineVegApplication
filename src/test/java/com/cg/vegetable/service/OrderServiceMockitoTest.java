package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.vegetable.module.OrderDet;
import com.cg.vegetable.repository.IOrderRepository;

@ExtendWith(SpringExtension.class)
class OrderServiceMockitoTest {

	@InjectMocks
	OrderServiceImpl ordService;

	@MockBean
	IOrderRepository iordrep;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	// @Disabled
	public void testAddOrder() {
		OrderDet ord = new OrderDet();
		ord.setOrderNo(6);
		ord.setCustId(128);
		ord.setOrderDate("2020-08-10");
		ord.setTotalAmount(200.00);
		ord.setStatus("Ordered");

		Mockito.when(iordrep.save(ord)).thenReturn(ord);

		OrderDet persistedOrd = ordService.addOrder(ord);

		assertEquals(6, persistedOrd.getOrderNo());
		assertEquals(128, persistedOrd.getCustId());
		assertEquals("2020-08-10", persistedOrd.getOrderDate());
		assertEquals(200.00, persistedOrd.getTotalAmount());
		assertEquals("Ordered", persistedOrd.getStatus());
	}

	@Test
	// @Disabled
	public void testViewOrderById() {
		OrderDet orderById = new OrderDet(10, 140, 200.00, "2020-09-08", "Ordered");

		Mockito.when(iordrep.findById(10)).thenReturn(Optional.of(orderById));

		OrderDet ord = ordService.viewOrder(10);

		assertEquals("2020-09-08", orderById.getOrderDate());
		assertEquals("Ordered", orderById.getStatus());

	}

	@Test
	// @Disabled
	public void testupdateOrderDetails() {
		OrderDet orderById = new OrderDet(11, 140, 200.00, "2020-09-08", "Ordered");

		Mockito.when(iordrep.findById(11)).thenReturn(Optional.of(orderById));
		Mockito.when(iordrep.save(orderById)).thenReturn(orderById);

		OrderDet ordupdate = ordService.updateOrderDetails(orderById);

		assertEquals("2020-09-08", ordupdate.getOrderDate());
		assertEquals("Ordered", ordupdate.getStatus());
	}

	@Test
	// @Disabled
	public void testCancelOrder() {
		OrderDet cancelorder = new OrderDet(13, 140, 200.00, "2020-09-08", "Cancelled");

		Mockito.when(iordrep.findById(13)).thenReturn(Optional.of(cancelorder));
		iordrep.deleteById(13);
		OrderDet ordupdate = ordService.cancelOrder(13);

		assertEquals(13, ordupdate.getOrderNo());
		assertEquals(140, ordupdate.getCustId());
		assertEquals(200.00, ordupdate.getTotalAmount());
		assertEquals("2020-09-08", ordupdate.getOrderDate());
		assertEquals("Cancelled", ordupdate.getStatus());

	}

	@Test
	// @Disabled
	void testviewAllOrdersByCustId() {
		OrderDet ord1 = new OrderDet(13, 140, 200.00, "2020-09-08", "Cancelled");
		OrderDet ord2 = new OrderDet(14, 140, 100.00, "2020-09-07", "Ordered");

		List<OrderDet> orders = new ArrayList<>();
		orders.add(ord1);
		orders.add(ord2);

		Mockito.when(iordrep.findAllOrdersByCustId(140)).thenReturn(orders);

		List<OrderDet> orderListByCustId = ordService.viewAllOrders(140);

		assertEquals(2, orderListByCustId.size());
	}

	@Test
	// @Disabled
	void testviewOrderListByDate() {
		OrderDet ord1 = new OrderDet(19, 150, 200.00, "2020-09-25", "Cancelled");
		OrderDet ord2 = new OrderDet(20, 140, 100.00, "2020-09-25", "Ordered");

		List<OrderDet> orders = new ArrayList<>();
		orders.add(ord1);
		orders.add(ord2);

		Mockito.when(iordrep.findAllOrdersByOrderDate("2020-09-25")).thenReturn(orders);

		List<OrderDet> orderListByOrderDate = ordService.viewOrderList("2020-09-25");

		assertEquals(2, orderListByOrderDate.size());
	}

	@Test
	// @Disabled
	void ltestviewOrderList() {
		OrderDet ord1 = new OrderDet(19, 150, 200.00, "2020-09-25", "Cancelled");
		OrderDet ord2 = new OrderDet(20, 140, 100.00, "2020-09-25", "Ordered");

		List<OrderDet> allOrders = new ArrayList<>();
		allOrders.add(ord1);
		allOrders.add(ord2);

		Mockito.when(iordrep.findAll()).thenReturn(allOrders);

		List<OrderDet> orderList = ordService.viewOrderList();

		assertEquals(2, orderList.size());
	}

}
