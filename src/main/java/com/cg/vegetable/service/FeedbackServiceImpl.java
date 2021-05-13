package com.cg.vegetable.service;

import java.util.List;

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
	public List<Feedback> viewAllFeedbacks(int vegetableId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feedback> viewFeedback(int customerId) {		
		return feedRepo.viewFeedback(customerId);
	}

}
