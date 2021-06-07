package com.cg.vegetable.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

/**
 * Feedback Entity
 *
 */
@Entity
public class Feedback {
	
	/**
	 * Creating instance variable for the class Feedback Entity
	 */
	@Id
	private int feedbackId;  
	@NotNull(message = "Rating cannot be empty")
	@Range(min=1, max=10, message= "Please rate out of 10")
    private int rating;
	@NotEmpty(message = "Comments cannot be empty")
	private String comments;
	
	/**
	 * FeedbackEntity is mapped to CustomerEntity
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id", referencedColumnName = "customerId")
	private Customer customer;
	
	/**
	 * FeedbackEntity is mapped to vegetableEntity
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="vegetables_id", referencedColumnName = "vegId")
	private Vegetable vegetable;
			
	/**
	 * Creating no arg constructor.
	 */
	public Feedback() {}
	
	/**
	 * Creating arg constructor.
	 */
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

	/**
	 * getters and setters
	 */
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

	/**
	 * Creating toString
	 */
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", rating=" + rating + ", comments=" + comments + ", customer="
				+ customer + ", vegetable=" + vegetable + "]";
	}

	
	
	
}