package com.cg.vegetable.module;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDet {
	@Id
	private int orderNo; 
	private double totalAmount;
	private String orderDate;
	private String status;
	
	//OneToMany mapping 
	/*@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="Order_No")
	private List<Vegetable> vegList;*/
	
	//ManyToOne mapping
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id",referencedColumnName = "customerId")
	private Customer customer;
	
	//parameterized constructor
	public OrderDet(int orderNo, double totalAmount,String orderDate,String status) {
		super();
		this.orderNo=orderNo;
		this.totalAmount=totalAmount;
		this.orderDate=orderDate;
		this.status=status;
	}
	
	
}
