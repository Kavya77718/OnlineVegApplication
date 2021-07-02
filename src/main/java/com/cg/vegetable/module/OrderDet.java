package com.cg.vegetable.module;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	@GeneratedValue
	private int orderNo; 
	private double totalAmount;
	private LocalDate orderDate = LocalDate.now();
	private String status;

	//OneToOne mapping with CartEntity
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Cart_Id")
	private Cart cartId;
	
	//ManyToOne mapping with customer

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
	
	//OneToOne mapping
	//	@JsonIgnore
	//	@OneToOne(cascade = CascadeType.ALL)
	//	@JoinColumn(name = "PaymentId")
	//	private Payments payment;
		
	//parameterized constructor
	public OrderDet(int orderNo, double totalAmount,LocalDate orderDate,String status) {
		super();
		this.orderNo=orderNo;
		this.totalAmount=totalAmount;
		this.orderDate=orderDate;
		this.status=status;
	}
}