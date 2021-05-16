package com.cg.vegetable.module;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrderDet {
	@Id
	private int orderNo;
	private int custId; 
	private double totalAmount;
	private String orderDate;
	private String status;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="Order_No")
	private List<Vegetable> vegList;
	/*
	public OrderDet(int orderNo,int custId,List<VegetableDTO> vegList, double totalAmount,String orderDate,String status) {
		super(); 
		this.orderNo=orderNo;
		this.custId=custId;
		this.vegList=vegList;
		this.totalAmount=totalAmount;
		this.orderDate=orderDate;
		this.status=status;
	} */
	public OrderDet(int orderNo,int custId, double totalAmount,String orderDate,String status) {
		super();
		this.orderNo=orderNo;
		this.custId=custId;
		this.totalAmount=totalAmount;
		this.orderDate=orderDate;
		this.status=status;
	}
	
	public OrderDet() {
		
	}

	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public List<Vegetable> getVegList() {
		return vegList; 
	}
	public void setVegList(List<Vegetable> vegList) {
		this.vegList = vegList;
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

	@Override
	public String toString() {
		return "OrderDet [orderNo=" + orderNo + ", custId=" + custId + ", vegList=" + vegList + ", totalAmount="
				+ totalAmount + ", orderDate=" + orderDate + ", status=" + status + "]";
	}
	
	
}
