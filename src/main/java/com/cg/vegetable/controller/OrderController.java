package com.cg.vegetable.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.vegetable.exception.OrderNotFoundException;
import com.cg.vegetable.module.OrderDet;
import com.cg.vegetable.module.OrderErrorResponse;
import com.cg.vegetable.service.IOrderService;
import org.apache.logging.log4j.LogManager;



@CrossOrigin
@RestController
@RequestMapping
public class OrderController {

	//Logger
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(OrderController.class);
		
	//AutoWiring the OrderService class to call down the service
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
	
	//using post mapping for adding order to the database
	@PostMapping("/order")
	public ResponseEntity<OrderDet> addOrder(@RequestBody OrderDet order) {	
		logger.info("Adding order details to the database");
		OrderDet addord = iord.addOrder(order);
		return ResponseEntity.ok(addord);
	}

	//Get order by id 
	@GetMapping("/order/id/{id}")
	public ResponseEntity<OrderDet> viewOrder(@PathVariable("id") int orderid) {
		logger.info("View order by id from the database");
		if( iord.viewOrder(orderid)==null) {
			throw new OrderNotFoundException("Order not found with order id "+orderid);
		}
		OrderDet ord = iord.viewOrder(orderid);
		return ResponseEntity.ok(ord);
	}
	
	//using put Mapping for updating order by id
	@PutMapping("/order/{id}") 
	public ResponseEntity<OrderDet> updateOrderDetails(@PathVariable("id") int orderid, @RequestBody OrderDet order) {
		logger.info("updating order by id");
		if( iord.viewOrder(orderid)==null) {
			throw new OrderNotFoundException("Order not found with order id "+orderid);
		}
		OrderDet updateord = iord.updateOrderDetails(order);
		return ResponseEntity.ok(updateord);
	}
	
	//Get list of orders by passing customer id
	@GetMapping("/order/customer/{customerid}")
	public ResponseEntity<List<OrderDet>> viewAllOrdersByCustId(@PathVariable("customerid") int customerId) {
		logger.info("finding orders by customer id from the database");
		if( iord.viewAllOrders(customerId).isEmpty()) {
			throw new OrderNotFoundException("Order not found with customer id "+customerId);
		}
		List<OrderDet> Custord = iord.viewAllOrders(customerId);
		return ResponseEntity.ok(Custord);
	}
	
    //using Get Mapping for Getting list of orders by passing date
	@GetMapping("/order/date/{date}")
	public ResponseEntity<List<OrderDet>> viewAllOrdersByOrderDate(@PathVariable("date") String orderDate){
		logger.info("finding orders by date from the database");
		if( iord.viewOrderList(orderDate).isEmpty()) {
			throw new OrderNotFoundException("Order not found with order date "+orderDate);
		}
		List<OrderDet> ordDate = iord.viewOrderList(orderDate);
		return ResponseEntity.ok(ordDate);
	}
	
	//using GetMapping for Getting list of orders
	@GetMapping("/order")
	public ResponseEntity<List<OrderDet>> viewOrderList(){
		logger.info("finding list of orders from the database");
		List<OrderDet> listord = iord.viewOrderList();
		return ResponseEntity.ok(listord);
	}
	
	//Delete order by passing orderId
	@DeleteMapping("/order/{id}")
	public OrderDet cancelOrder(@PathVariable("id") int orderid) {
		logger.info("deleting order from the database");
		if( iord.viewOrder(orderid)==null) {
			throw new OrderNotFoundException("Order not found with order id "+orderid);
		}
		return iord.cancelOrder(orderid);
	}
	
}