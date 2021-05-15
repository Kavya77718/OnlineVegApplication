package com.cg.vegetable.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.vegetable.module.OrderDet;
import com.cg.vegetable.module.VegetableDTO;


public interface IOrderService {

	public OrderDet addOrder(OrderDet order);
	public OrderDet viewOrder(int orderid);
	public OrderDet updateOrderDetails(OrderDet order);
	public List<OrderDet> viewAllOrders(int custId);
	public List<OrderDet> viewOrderList(String orderDate);
	public List<OrderDet> viewOrderList();
	public OrderDet cancelOrder(int orderid);
	public VegetableDTO addVegetable(VegetableDTO dto);

}
