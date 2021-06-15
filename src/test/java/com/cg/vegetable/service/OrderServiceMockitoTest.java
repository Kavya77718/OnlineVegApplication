package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.cg.vegetable.module.Customer;
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
	
	// Testing whether the new order is adding or not
	@Test
	//@Disabled
	public void testAddOrder() {
		OrderDet ord = new OrderDet();
		ord.setOrderNo(6);
		ord.setOrderDate(LocalDate.of(2020, 8, 10));
		ord.setTotalAmount(200.00);
		ord.setStatus("Ordered");
		
		Mockito.when(iordrep.save(ord)).thenReturn(ord);
		
		OrderDet persistedOrd = ordService.addOrder(ord);
		assertEquals(6,persistedOrd.getOrderNo());
		assertEquals("2020-08-10",persistedOrd.getOrderDate());
		assertEquals(200.00,persistedOrd.getTotalAmount());
		assertEquals("Ordered",persistedOrd.getStatus());
	}
	
	// Testing whether the given id fetches the given order or not.
	@Test
	//@Disabled
	public void testViewOrderById() {
		OrderDet orderById = new OrderDet(10,200.00,LocalDate.of(2020, 8, 10),"Ordered");
		
		Mockito.when(iordrep.findById(10)).thenReturn(Optional.of(orderById));
		
		OrderDet ord = ordService.viewOrder(10);
		
		assertEquals("2020-09-08",ord.getOrderDate());
		assertEquals("Ordered", ord.getStatus());
	
	}
	
	// Testing whether the given id fetches the given order to update and whether it is updating the order
	/*@Test
	
	//@Disabled
	public void testupdateOrderDetails() {
		OrderDet orderById = new OrderDet(11,200.00,LocalDate.of(2020, 8, 10),"Ordered");
		
		Mockito.when(iordrep.findById(11)).thenReturn(Optional.of(orderById));
		Mockito.when(iordrep.save(orderById)).thenReturn(orderById);
		
	OrderDet ordupdate = ordService.updateOrderDetails(orderById);
		
		assertEquals("2020-09-08",ordupdate.getOrderDate());
		assertEquals("Ordered", ordupdate.getStatus());
	}
	*/
	// Testing whether the given id fetches and deleted the given order or not
	@Test
	@Disabled
	public void testCancelOrder() {
		OrderDet cancelorder = new OrderDet(13,200.00,LocalDate.of(2020, 8, 10),"Cancelled");
		
		Mockito.when(iordrep.findById(13)).thenReturn(Optional.of(cancelorder));
		iordrep.deleteById(13);
		OrderDet ordupdate = ordService.cancelOrder(13);
		
		assertEquals(13, ordupdate.getOrderNo());
		assertEquals(200.00, ordupdate.getTotalAmount());
		assertEquals("2020-09-08", ordupdate.getOrderDate());
		assertEquals("Cancelled", ordupdate.getStatus());
		
	}
	
	// Testing whether the given customer id fetches the list of orders or not.
	@Test
	//@Disabled
	void testviewAllOrdersByCustId() {
			OrderDet ord1 = new OrderDet(13,200.00,LocalDate.of(2020, 8, 10),"Cancelled");
			OrderDet ord2 = new OrderDet(14,100.00,LocalDate.of(2020, 8, 10),"Ordered");
			Customer customer1 = new Customer(1,"Ambica", "886535214", "abcd@g.com");
			
			ord1.setCustomer(customer1);
			ord2.setCustomer(customer1);
			
			List<OrderDet> OrderList = new ArrayList<>();
			OrderList.add(ord1);
			OrderList.add(ord2);
			
			Mockito.when(iordrep.viewOrderList(1)).thenReturn(OrderList);
					List<OrderDet> feed = ordService.viewAllOrders(1);
			assertEquals(2, feed.size());
		}
	
	// Testing whether the given date fetches the list of orders or not.
	@Test
	//@Disabled
	void testviewOrderListByDate() {
		OrderDet ord1 = new OrderDet(19,200.00,LocalDate.of(2020, 8, 10),"Cancelled");
		OrderDet ord2 = new OrderDet(20,100.00,LocalDate.of(2020, 8, 10),"Ordered");
		
		List<OrderDet> orders = new ArrayList<>();
		orders.add(ord1);
		orders.add(ord2);
		
		Mockito.when(iordrep.findAllOrdersByOrderDate(LocalDate.of(2020, 8, 10))).thenReturn(orders);
		
		List<OrderDet> orderListByOrderDate = ordService.viewOrderList(LocalDate.of(2020, 8, 10));
		
		assertEquals(2, orderListByOrderDate.size());
	}

	// Testing whether the it fetches the list of orders or not.
	@Test
	//@Disabled
	void ltestviewOrderList() {
		OrderDet ord1 = new OrderDet(19,200.00,LocalDate.of(2020, 8, 10),"Cancelled");
		OrderDet ord2 = new OrderDet(20,100.00,LocalDate.of(2020, 8, 10),"Ordered");
		
		List<OrderDet> allOrders = new ArrayList<>();
		allOrders.add(ord1);
		allOrders.add(ord2);
	
		Mockito.when(iordrep.findAll()).thenReturn(allOrders);
		
		List<OrderDet> orderList = ordService.viewOrderList();
		
		assertEquals(2,orderList.size());
	}
	 
	
	
}

