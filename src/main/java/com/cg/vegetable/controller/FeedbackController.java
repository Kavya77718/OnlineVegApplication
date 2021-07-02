package com.cg.vegetable.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.vegetable.exception.AddressNotFoundException;
import com.cg.vegetable.exception.FeedbackNotFoundException;
import com.cg.vegetable.module.Customer;
import com.cg.vegetable.module.Feedback;
import com.cg.vegetable.service.IFeedbackService;

@CrossOrigin
@RestController
public class FeedbackController {
	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(FeedbackController.class);

	/**
	 * We are autowiring the feedback service layer to this controller layer of
	 * feedback
	 * 
	 * @param feedbackServiceImpl
	 */
	@Autowired
	IFeedbackService feedServ;

	/**
	 * This controller is used to create a new or add new feedback and redirects it
	 * to the service layer
	 * 
	 * @param
	 * @return
	 */
	@PostMapping("/feedback")
	public ResponseEntity<Feedback> addFeedback(@Valid @RequestBody Feedback fdk) {
		logger.info("adding feedback");
		Feedback feed = feedServ.addFeedback(fdk);
		return ResponseEntity.ok(feed);
	}
	
	/**
	 * This controller is used to create a new or add new feedback and redirects it
	 * to the service layer
	 * 
	 * @param
	 * @return
	 */
	@PostMapping("/feedback/{custId}/{rating}/{comments}")
	public ResponseEntity<Feedback> addFeedback(@PathVariable("custId") int customerId,@PathVariable int rating,@PathVariable String comments) {
		logger.info("adding feedback");
		Feedback feed = feedServ.addFeedback(customerId,rating, comments);
		return ResponseEntity.ok(feed);
	}


	/**
		 * This controller is used to get all feedback on basis of customerId
		 * 
		 * @param customerId 
		 * @return
		 */
		@GetMapping("/feedback/{id}")
		public ResponseEntity<List<Feedback>> viewCustomer(@PathVariable("id") int customerId) {
			logger.info("getting all feedback by id by passing customerId");
			List<Feedback> feed = feedServ.viewFeedback(customerId);
			return ResponseEntity.ok(feed);
		}

	/**
	 * This controller is used to get all feedback on basis of vegetableId
	 * 
	 * @param customerId
	 * @return
	 */
	@GetMapping("/viewfeedback/{id}")
	public ResponseEntity<List<Feedback>> viewAllFeedbacks(@PathVariable("id") int vegetableId) {
		logger.info("getting all feedback by passing vegetableId");
		List<Feedback> feed = feedServ.viewAllFeedbacks(vegetableId);
		return ResponseEntity.ok(feed);
	}

	/**
	 * 
	 * this controller function perform deletion of a specific given feedback and
	 * request the service to perform the action and returns the message as deleted
	 * else throw exception
	 * 
	 * @param vegetableId
	 * @return
	 * @throws FeedbackNotFoundException
	 */
	@DeleteMapping("/feedback/{id}")
	public Feedback deleteFeedbackById(@PathVariable("id") int feedbackId) {
		logger.info("deleting feedback by id");
		if (feedServ.deleteFeedbackById(feedbackId) == null) {
			throw new FeedbackNotFoundException("Feedback not found with this id" + feedbackId);
		}
		return feedServ.deleteFeedbackById(feedbackId);
	}

	/**
	 * This controller is used to return and list all the feedback found in the
	 * database and request to the service to perform the action
	 * 
	 * @return
	 */
	@GetMapping("/feedback")
	public ResponseEntity<List<Feedback>> findAllFeedback() {
		logger.info("getting list of feedback");
		List<Feedback> feed = feedServ.findAllFeedback();
		return ResponseEntity.ok(feed);
	}

}
