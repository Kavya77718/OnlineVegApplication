package com.cg.vegetable.module;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Payments {
	@Id
	@GeneratedValue
    private	long paymentId;
	private	String paymentType;
	private  double itemTotal;
	private	 double shippingFee;
	private double totalPrice;
	
	@OneToMany(targetEntity = OrderDet.class,cascade = CascadeType.ALL)
	@JoinColumn(name= "pay_Id",referencedColumnName = "paymentId ")
	private List<OrderDet> orders;
	
	/* public Payments(long paymentId, String paymentType, double itemTotal,
			double shippingFee, double totalPrice, List<OrderDet> orders) {
		super();
		this.paymentId = paymentId;
		this.paymentType = paymentType;
		this.itemTotal = itemTotal;
		this.shippingFee = shippingFee;
		this.totalPrice = totalPrice;
		this.orders = orders;
	} */
	public Payments(long paymentId, String paymentType, double itemTotal,
			double shippingFee, double totalPrice) {
		super();
		this.paymentId = paymentId;
		this.paymentType = paymentType;
		this.itemTotal = itemTotal;
		this.shippingFee = shippingFee;
		this.totalPrice = totalPrice;
	}
	public Payments() {
		
	}

public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}

	public double getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(double shippingFee) {
		this.shippingFee = shippingFee;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<OrderDet> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDet> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Payments [paymentId=" + paymentId + ", paymentType=" + paymentType + ", itemTotal=" + itemTotal
				+ ", shippingFee=" + shippingFee + ", totalPrice=" + totalPrice + ", orders=" + orders + "]";
	}
	
}