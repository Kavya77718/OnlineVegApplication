package com.cg.vegetable.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Feedback Entity
 *
 */
@Getter
@Setter
@ToString
@Entity
public class Feedback {
	
	/**
	 * Creating instance variable for the class Feedback Entity
	 */
	@Id
	@GeneratedValue
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
	//@JoinColumn(name="vegetables_id", referencedColumnName = "vegId")
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



	
	
	
}