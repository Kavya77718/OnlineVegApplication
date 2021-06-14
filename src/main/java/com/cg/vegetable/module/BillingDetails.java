package com.cg.vegetable.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BillingEntity class
 *
 */


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingDetails {
	/**
	 * creating instance variables for the class BillingEntity
	 */
	@Id
	@GeneratedValue
	private int billingId;

	//@JsonIgnore
	@OneToOne(targetEntity = OrderDet.class, cascade = CascadeType.ALL)
	/**
	 * BillingEntity is mapped to OrderEntity
	 * 
	 */
	@JoinColumn(name = "order_id", referencedColumnName = "orderNo")
	private OrderDet order;

	//@JsonIgnore
	/**
	 * BillingEntity is mapped to CustomerEntity
	 * 
	 */
	@OneToOne(targetEntity = Customer.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerName", referencedColumnName = "Name")
	//@JoinColumn(name = "", referencedColumnName = "Name")
	private Customer customer;
	
	//@JsonIgnore
	@OneToOne(targetEntity = Payments.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "transactionStatus", referencedColumnName = "transactionStatus")
	@JoinColumn(name = "transactionMode", referencedColumnName = "transactionMode")
	@JoinColumn(name = "transactionDate", referencedColumnName = "transactionDate")
	/**
	 * BillingEntity is mapped to PaymentEntity
	 * 
	 */
	
	private Payments payments;

	public BillingDetails(int billingId) {
		super();
		this.billingId = billingId;

	}
}
