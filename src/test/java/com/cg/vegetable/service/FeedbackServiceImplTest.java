package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vegetable.module.Address;
import com.cg.vegetable.module.Customer;
import com.cg.vegetable.module.Feedback;

@SpringBootTest
public class FeedbackServiceImplTest {
	
	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(FeedbackServiceImplTest.class);

	/**
	 * Autowiring the FeedbackServiceImplTest class to call down the service
	 */
	@Autowired
	IFeedbackService feedService;
	
	/**
	 * This below function is used to test the testAddFeedback and to check whether it adds Feedback to the database
	 */
	@Test
	@Disabled
	void  testAddFeedback() {
		logger.info("adding feedback");
		Feedback feedback = new Feedback(5, 10, "good");
		Customer customer1 = new Customer(1,"Kavya", "886535214", "abcd@g.com");
		feedback.setCustomer(customer1);
		Feedback persistedCust =  feedService.addFeedback(feedback);
		assertEquals(10, persistedCust.getRating());
    }
	
	/**
	 * This below function is used to test the testViewFeedback and to check whether it retrieves feedback by customerId
	 * from the database
	 */
	@Test
	//@Disabled
	void testViewFeedback() {
		logger.info("getting the list of feedback by passing the customerId");
		List<Feedback> feed = feedService.viewFeedback(1);
		assertEquals(2, feed.size());
	}
	
	/**
	 * This below function is used to test the testViewAllFeedback and to check whether it retrieves feedback by vegetableId
	 * from the database
	 */
	@Test
	//@Disabled
	void testViewAllFeedback() {
		logger.info("getting the list of feedback by passing the vegetableId");
		List<Feedback> feed = feedService.viewAllFeedbacks(20);
		assertEquals(1, feed.size());
	}	
	
	/**
	 * This below function is used to test the testDeleteFeedbackById and to check whether it deletes feedback by id
	 *  from the database
	 */
	@Test
	@Disabled
	void testDeleteFeedbackById() {
		logger.info("delete feedback by id");
		Feedback feed = feedService.deleteFeedbackById(4);
		assertEquals(4, feed.getFeedbackId());
	}
	
	/**
	 * This below function is used to test the testFindAllFeedback and to check whether it retrieves all feedback 
	 * from the database
	 */
	@Test
	//@Disabled
	void testFindAllFeedback() {
		List<Feedback> feedback=feedService.findAllFeedback();
		logger.info(feedback);
		assertEquals(4, feedback.size());
	}

}
