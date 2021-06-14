package com.cg.vegetable.module;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payments {
	@Id
	@GeneratedValue
	private long paymentId;
	private String transactionMode;
	private double itemTotal;
	private double shippingFee;
	private double totalPrice;
	private String transactionStatus;
	private LocalDate transactionDate;

	//OneToOne mapping
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Order_Id")
	private OrderDet orderNo;

	//parameterized constructor
	public Payments(long paymentId, String transactionMode, double itemTotal, double shippingFee, double totalPrice, String transactionStatus, LocalDate transactionDate) {
		super();
		this.paymentId = paymentId;
		this.transactionMode = transactionMode;
		this.itemTotal = itemTotal;
		this.shippingFee = shippingFee;
		this.totalPrice = totalPrice;
		this.transactionStatus=transactionStatus;
		this.transactionDate=transactionDate;
		
	}

}