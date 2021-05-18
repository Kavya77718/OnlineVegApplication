package com.cg.vegetable.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.vegetable.module.Feedback;
import com.cg.vegetable.repository.IFeedbackRepository;

@Service
public class FeedbackServiceImpl implements IFeedbackService {
	
	@Autowired
	IFeedbackRepository feedRepo;

	@Override
	public Feedback addFeedback(Feedback fdk) {
		return feedRepo.save(fdk);
	}
	
	@Override
	public List<Feedback> viewFeedback(int customerId) {
		return feedRepo.viewFeedback(customerId);
	}
	
	@Override
	public List<Feedback> viewAllFeedbacks(int vegetableId) {
	     List<Feedback> feedbackList = feedRepo.findAll();
	     List<Feedback> feeList = new ArrayList<>();
	     for(Feedback feed : feedbackList) {
	    	 if(feed.getVegetable().getVegId() == vegetableId) {
	    		 feeList.add(feed);
	    	 } 
	     }
	     return feeList;
	}

	@Override
	public Feedback deleteFeedbackById(int feedbackId){
		Optional<Feedback> feedback = feedRepo.findById(feedbackId);
		if(!feedback.isPresent()) {
			return null;
		}
		feedRepo.delete(feedback.get());
		return feedback.get();

	}
	
	}


