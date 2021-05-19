package com.cg.vegetable.module;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OrderDet {
	@Id
	private int orderNo; 
	private double totalAmount;
	private String orderDate;
	private String status;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="Order_No")
	private List<Vegetable> vegList;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id",referencedColumnName = "customerId")
	private Customer customer;
	
	public OrderDet(int orderNo, double totalAmount,String orderDate,String status) {
		super();
		this.orderNo=orderNo;
		this.totalAmount=totalAmount;
		this.orderDate=orderDate;
		this.status=status;
	}
	
	//default constructor
	public OrderDet() {
		
	}

	//Getters and setters
	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Vegetable> getVegList() {
		return vegList;
	}

	public void setVegList(List<Vegetable> vegList) {
		this.vegList = vegList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	//Generate toString
	@Override
	public String toString() {
		return "OrderDet [orderNo=" + orderNo + ", totalAmount=" + totalAmount + ", orderDate=" + orderDate
				+ ", status=" + status + ", vegList=" + vegList + ", customer=" + customer + "]";
	}

	
}