

package com.cg.vegetable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.vegetable.exception.FeedbackNotFoundException;
import com.cg.vegetable.module.Feedback;
import com.cg.vegetable.service.IFeedbackService;

@RestController
public class FeedbackController {
	@Autowired
	IFeedbackService feedServ;
	
	// add feedback
	@PostMapping("/feedback")
	public Feedback addFeedback(@RequestBody Feedback fdk) {
		return feedServ.addFeedback(fdk);
	}
	
	// view list of feedback with customerId
	@GetMapping("/feedback/{id}")
	public List<Feedback> viewCustomer(@PathVariable("id") int customerId) {
		return feedServ.viewFeedback(customerId);
	}
	
	//view list of feedback with vegId
	@GetMapping("/viewfeedback/{id}")
	public List<Feedback> viewAllFeedbacks(@PathVariable("id") int vegetableId) {
		return feedServ.viewAllFeedbacks(vegetableId);
	}
	
	//delete feedback
	@DeleteMapping("/feedback/{id}")
	public Feedback deleteFeedbackById(@PathVariable("id") int feedbackId) {
		if (feedServ.deleteFeedbackById(feedbackId) == null) {
			throw new FeedbackNotFoundException("Feedback not found with this id" + feedbackId);
		}
		return feedServ.deleteFeedbackById(feedbackId);
	}
	
}

