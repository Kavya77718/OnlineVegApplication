package com.cg.vegetable.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Feedback {
	@Id
	private int feedbackId;  
	private int rating;
	private String comments;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id", referencedColumnName = "customerId")
	private Customer customer;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="vegetables_id", referencedColumnName = "vegId")
	private Vegetable vegetable;
		
	//Default Constructor
	public Feedback() {}
	
	//Parameterized Constructor
	public Feedback(int feedbackId, int rating, String comments) {
		super();
		this.feedbackId = feedbackId;
		this.rating = rating;
		this.comments = comments;
	}
			
	//Getters & setters
	public Feedback(int feedbackId) {
		super();
		this.feedbackId = feedbackId;
	}

	public int getFeedbackId() {
		return feedbackId;
	}
	
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
		
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vegetable getVegetable() {
		return vegetable;
	}

	public void setVegetable(Vegetable vegetable) {
		this.vegetable = vegetable;
	}

	//ToString
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", rating=" + rating + ", comments=" + comments + ", customer="
				+ customer + ", vegetable=" + vegetable + "]";
	}

	
	
	
}