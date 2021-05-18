package com.cg.vegetable.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.vegetable.exception.OrderNotFoundException;
import com.cg.vegetable.module.OrderDet;
import com.cg.vegetable.module.OrderErrorResponse;
import com.cg.vegetable.service.IOrderService;

@RestController
public class OrderController {

	@Autowired
	IOrderService iord;
	
	@ExceptionHandler
	public ResponseEntity<OrderErrorResponse> handleException(OrderNotFoundException exception){
		OrderErrorResponse error = new OrderErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	//Add order
	@PostMapping("/order")
	public OrderDet addOrder(@RequestBody OrderDet order) {	
		return iord.addOrder(order);
	}

	//Get order 
	@GetMapping("/order/id/{id}")
	public OrderDet viewOrder(@PathVariable("id") int orderid) {
		if( iord.viewOrder(orderid)==null) {
			throw new OrderNotFoundException("Order not found with order id "+orderid);
		}
		return iord.viewOrder(orderid);
	}
	
	//Update order
	@PutMapping("/order/{id}") 
	public OrderDet updateOrderDetails(@PathVariable("id") int orderid, @RequestBody OrderDet order) {
		if( iord.viewOrder(orderid)==null) {
			throw new OrderNotFoundException("Order not found with order id "+orderid);
		}
		return iord.updateOrderDetails(order);
	}
	
	//Get list of orders by passing customer id
	@GetMapping("/order/customer/{customerid}")
	public List<OrderDet> viewAllOrdersByCustId(@PathVariable("customerid") int customerId) {
		if( iord.viewAllOrders(customerId).isEmpty()) {
			throw new OrderNotFoundException("Order not found with customer id "+customerId);
		}
		return iord.viewAllOrders(customerId);
	}
    //Get list of orders by passing date
	@GetMapping("/order/date/{date}")
	public List<OrderDet> viewAllOrdersByOrderDate(@PathVariable("date") String orderDate){
		if( iord.viewOrderList(orderDate).isEmpty()) {
			throw new OrderNotFoundException("Order not found with order date "+orderDate);
		}
		return iord.viewOrderList(orderDate);
	}
	
	//Get list of orders
	@GetMapping("/order")
	public List<OrderDet> viewOrderList(){
		return iord.viewOrderList();
	}
	
	//Delete order by passing orderId
	@DeleteMapping("/order/{id}")
	public OrderDet cancelOrder(@PathVariable("id") int orderid) {
		if( iord.viewOrder(orderid)==null) {
			throw new OrderNotFoundException("Order not found with order id "+orderid);
		}
		return iord.cancelOrder(orderid);
	}
	
	
}