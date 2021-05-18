package com.cg.vegetable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vegetable.module.Feedback;
import com.cg.vegetable.service.IFeedbackService;

@RestController
public class FeedbackController {
	@Autowired
	IFeedbackService feedServ;
	
	// add
	@PostMapping("/feedback")
	public Feedback addFeedback(@RequestBody Feedback fdk) {
		return feedServ.addFeedback(fdk);
	}
	
	// view
	@GetMapping("/feedback/{id}")
	public List<Feedback> viewCustomer(@PathVariable("id") int customerId) {
		return feedServ.viewFeedback(customerId);
	}

}
