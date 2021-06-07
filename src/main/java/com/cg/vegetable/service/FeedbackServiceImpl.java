package com.cg.vegetable.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vegetable.module.Customer;
import com.cg.vegetable.module.Feedback;
import com.cg.vegetable.repository.IFeedbackRepository;

@Service
public class FeedbackServiceImpl implements IFeedbackService {

	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(FeedbackServiceImpl.class);

	/**
	 * Autowiring the IFeedbackRepository class to call down the service
	 */
	@Autowired
	IFeedbackRepository feedRepo;

	/*
	 * This below function addFeedback is used to create new feedback and redirects
	 * to feedRepo.
	 */
	@Override
	public Feedback addFeedback(Feedback fdk) {
		logger.info("adding feedback");
		return feedRepo.save(fdk);
	}

	/*
	 * This below function viewFeedback is used to retrieve all feedback by
	 * customerId and redirects to feedRepo.
	 */
	@Override
	public List<Feedback> viewFeedback(int customerId) {
		logger.info("getting the list of feedback by passing the customerId");
		return feedRepo.viewFeedback(customerId);
	}

	/*
	 * This below function viewAllFeedbacks is used to retrieve all feedback by
	 * vegetableId and redirects to feedRepo.
	 */
	@Override
	public List<Feedback> viewAllFeedbacks(int vegetableId) {
		logger.info("getting the list of feedback by passing the vegetableId");
		List<Feedback> feedbackList = feedRepo.findAll();
		List<Feedback> feeList = new ArrayList<>();
		for (Feedback feed : feedbackList) {
			if (feed.getVegetable().getVegId() == vegetableId) {
				feeList.add(feed);
			}
		}
		return feeList;
	}

	/*
	 * This below function deleteFeedbackById is used to delete the feedback and
	 * redirects to feedRepo.
	 */
	@Override
	public Feedback deleteFeedbackById(int feedbackId) {
		logger.info("deleting feedback by id");
		Optional<Feedback> feedback = feedRepo.findById(feedbackId);
		if (!feedback.isPresent()) {
			return null;
		}
		feedRepo.delete(feedback.get());
		return feedback.get();

	}

	/*
	 * This below function findAllFeedback is used to get all the feedbacks and
	 * redirects to feedRepo.
	 */
	@Override
	public List<Feedback> findAllFeedback() {
		logger.info("getting list of Feedback");
		return feedRepo.findAll();
	}

}
