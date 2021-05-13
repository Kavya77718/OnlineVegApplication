package com.cg.vegetable.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Feedback {
	@Id
	private int feedbackId;  
	private int vegetableId;
    private int rating;
	private String comments;
		
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id", referencedColumnName = "customerId")
	private Customer customer;
	
	public Feedback() {}
	
	public Feedback(int feedbackId, int vegetableId, int rating, String comments) {
		super();
		this.feedbackId = feedbackId;
		this.vegetableId = vegetableId;
		this.rating = rating;
		this.comments = comments;
	}
	
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	
	public int getVegetableId() {
		return vegetableId;
	}
	public void setVegetableId(int vegetableId) {
		this.vegetableId = vegetableId;
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


	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", vegetableId=" + vegetableId + ", customer=" + customer
				+ ", rating=" + rating + ", comments=" + comments + "]";
	}
	
}