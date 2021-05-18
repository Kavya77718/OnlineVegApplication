package com.cg.vegetable.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
			
	public Feedback() {}
	
	public Feedback(int feedbackId, int rating, String comments) {
		super();
		this.feedbackId = feedbackId;
		this.rating = rating;
		this.comments = comments;
	}
			
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

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", rating=" + rating + ", comments=" + comments + ", customer="
				+ customer + ", vegetable=" + vegetable + "]";
	}

	
	
	
}