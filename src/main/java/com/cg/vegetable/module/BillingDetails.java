package com.cg.vegetable.module;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billtab")
public class BillingDetails {
	@Id
	private int billingId;
	private String transactionMode;
	private String transactionDate;
	private String transactionStatus;

	public BillingDetails() {
	}

	public BillingDetails(int billingId, String transactionMode, String transactionDate, String transactionStatus) {
		super();
		this.billingId = billingId;
		this.transactionMode = transactionMode;
		this.transactionDate = transactionDate;
		this.transactionStatus = transactionStatus;
	}

	public int getBillingId() {
		return billingId;
	}

	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	@Override
	public String toString() {
		return "BillingDetails [billingId=" + billingId + ", transactionMode=" + transactionMode + ", transactionDate="
				+ transactionDate + ", transactionStatus=" + transactionStatus + "]";
	}
}


