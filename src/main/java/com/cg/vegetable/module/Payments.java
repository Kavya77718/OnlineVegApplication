package com.cg.vegetable.module;

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
	private String paymentType;
	private double itemTotal;
	private double shippingFee;
	private double totalPrice;

	//OneToOne mapping
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Order_Id")
	private OrderDet orderNo;

	//parameterized constructor
	public Payments(long paymentId, String paymentType, double itemTotal, double shippingFee, double totalPrice) {
		super();
		this.paymentId = paymentId;
		this.paymentType = paymentType;
		this.itemTotal = itemTotal;
		this.shippingFee = shippingFee;
		this.totalPrice = totalPrice;
	}

}