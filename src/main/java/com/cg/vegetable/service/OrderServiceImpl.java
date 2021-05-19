package com.cg.vegetable.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.vegetable.module.OrderDet;
import com.cg.vegetable.repository.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService{
 
	@Autowired
	IOrderRepository iordr;

	@Override
	public OrderDet addOrder(OrderDet order) {
		return iordr.save(order);
	}

	@Override
	public OrderDet viewOrder(int orderid) {
		Optional<OrderDet> ord = iordr.findById(orderid);
		if(!ord.isPresent()) {
			return null;
		}
		return ord.get();
	}
	
	@Override
	public OrderDet updateOrderDetails(OrderDet order) {
		OrderDet ord = iordr.findById(order.getOrderNo()).get();
		ord.setCustomer(order.getCustomer());
		ord.setVegList(order.getVegList());
		ord.setTotalAmount(order.getTotalAmount());
		return iordr.save(order);
		
	}
	@Override
	public List<OrderDet> viewAllOrders(int customerId) {
		return iordr.viewOrderList(customerId);
	}

	@Override
	public List<OrderDet> viewOrderList(String orderDate) {
		return iordr.findAllOrdersByOrderDate(orderDate);
	}

	@Override
	public List<OrderDet> viewOrderList() {
		return iordr.findAll();
	}

	@Override
	public OrderDet cancelOrder(int orderid) {
		Optional<OrderDet> ord = iordr.findById(orderid);
		if(!ord.isPresent()) {
			return null;
		}
		iordr.deleteById(orderid);
		return ord.get();
	}

	

}