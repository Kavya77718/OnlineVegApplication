package com.cg.vegetable.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vegetable.module.Cart;
import com.cg.vegetable.module.OrderDet;
import com.cg.vegetable.module.Payments;
import com.cg.vegetable.repository.ICartRepository;
import com.cg.vegetable.repository.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService{
 
	//Logger
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(OrderServiceImpl.class);
	
	//AutoWiring the OrderServiceTest class to call down the service
	@Autowired
	IOrderRepository iordr;
	
	@Autowired
	ICartRepository cartRep;

	// This method id To add or create new order 
	@Override
	public OrderDet addOrder(OrderDet order) {
		logger.info("Adding order details to the database");
		return iordr.save(order);
	}

	//To view order by id called from the controller class and send back to the controller
	@Override
	public OrderDet viewOrder(int orderid) {
		Optional<OrderDet> ord = iordr.findById(orderid);
		logger.info("View order by id from the database");
		if(!ord.isPresent()) {
			return null;
		}
		return ord.get();
	}
	
	//To update order by id called from the controller class and send back to the controller
	/*@Override
	public OrderDet updateOrderDetails(OrderDet order) {
		logger.info("updating order by id");
		OrderDet ord = iordr.findById(order.getOrderNo()).get();
		ord.setTotalAmount(order.getTotalAmount());
		return iordr.save(order);	
	}*/
	
	//To list all the orders by customer id called from the controller class and send back to the controller
	@Override
	public List<OrderDet> viewAllOrders(int customerId) {
		logger.info("finding orders by customer id from the database");
		return iordr.viewOrderList(customerId);
	}

	//To list all the orders by order date called from the controller class and send back to the controller
	@Override
	public List<OrderDet> viewOrderList(LocalDate orderDate) {
		logger.info("finding orders by date from the database");
		return iordr.findAllOrdersByOrderDate(orderDate);
	}

	@Override
	public List<OrderDet> viewOrderList() {
		logger.info("finding list of orders from the database");
		return iordr.findAll();
	}

	//To delete the order by order id from the controller class
	@Override
	public OrderDet cancelOrder(int orderid) {
		logger.info("deleting order from the database");
		Optional<OrderDet> ord = iordr.findById(orderid);
		if(!ord.isPresent()) {
			return null;
		}
		iordr.deleteById(orderid);
		return ord.get();
	}

	@Override
	public OrderDet addOrderByCart(int cartId, OrderDet order) {
			Optional<Cart> pa = cartRep.findById(cartId);
			if (pa.isPresent()) {
				return iordr.save(order);
			}
			return null;
	}
	
}
