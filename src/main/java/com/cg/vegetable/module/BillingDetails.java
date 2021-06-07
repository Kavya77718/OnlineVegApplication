package com.cg.vegetable.module;

import javax.persistence.Entity;
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
	private int billingId;

	@JsonIgnore
	@OneToOne(targetEntity = OrderDet.class, cascade = CascadeType.ALL)
	/**
	 * BillingEntity is mapped to OrderEntity
	 * 
	 */
	@JoinColumn(name = "order_id", referencedColumnName = "orderNo")
	private OrderDet order;
	@JsonIgnore
	/**
	 * BillingEntity is mapped to CustomerEntity
	 * 
	 */
	@OneToOne(targetEntity = Customer.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", referencedColumnName = "customerId")
	private Customer customer;
	@NotEmpty(message = "transactionMode should not be empty")
	private String transactionMode;
	@NotEmpty(message = "transactionDate should not be empty")
	private String transactionDate;
	@NotEmpty(message = "transactionStatus should not be empty")
	private String transactionStatus;

	public BillingDetails(int billingId, String transactionMode, String transactionDate, String transactionStatus) {
		super();
		this.billingId = billingId;
		this.transactionMode = transactionMode;
		this.transactionDate = transactionDate;
		this.transactionStatus = transactionStatus;
	}
}