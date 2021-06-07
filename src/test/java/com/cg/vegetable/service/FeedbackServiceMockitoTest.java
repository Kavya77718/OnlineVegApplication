	package com.cg.vegetable.service;
	
	import static org.junit.jupiter.api.Assertions.assertEquals;
	
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;
	
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Disabled;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mockito;
	import org.mockito.MockitoAnnotations;
	import org.springframework.boot.test.mock.mockito.MockBean;
	import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.vegetable.module.Address;
import com.cg.vegetable.module.Customer;
	import com.cg.vegetable.module.Feedback;
	import com.cg.vegetable.module.Vegetable;
	import com.cg.vegetable.repository.IFeedbackRepository;
	
	@ExtendWith(SpringExtension.class)
	public class FeedbackServiceMockitoTest {
	
		
	@InjectMocks
	FeedbackServiceImpl feedService;
	
	@MockBean
	IFeedbackRepository feedRep;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	/**
	 * This below function is Mockito test case used to test the testAddFeedback and to check whether it adds Feedback to the database
	 */
	@Test
	//@Disabled
	void testAddFeedback() {
		Feedback feedback = new Feedback(5, 10, "good");
		Customer customer = new Customer(1,"Kavya", "886535214", "abcd@g.com");
		feedback.setCustomer(customer);
		Mockito.when(feedRep.save(feedback)).thenReturn(feedback);
		Feedback persistedFeed = feedService.addFeedback(feedback);
		assertEquals(5, persistedFeed.getFeedbackId());
	}
	
	/**
	 * This below function is Mockito test case used to test the testViewFeedback and to check whether it retrieves feedback by customerId
	 * from the database
	 */
	@Test
	//@Disabled
	void testviewFeedback() {
		Feedback feedback1 = new Feedback(5, 10, "good");
		Feedback feedback2 = new Feedback(6, 10, "good");
		Customer customer1 = new Customer(5, "Ad", "7890654", "ad@g.com");
		feedback1.setCustomer(customer1);
		feedback2.setCustomer(customer1);
		List<Feedback> FeedbackList = new ArrayList<>();
		FeedbackList.add(feedback1);
		FeedbackList.add(feedback2);
		Mockito.when(feedRep.viewFeedback(1)).thenReturn(FeedbackList);
		List<Feedback> feed = feedService.viewFeedback(1);
		assertEquals(2, feed.size());
	}
	
	/**
	 * This below function is Mockito test case used to test the testViewAllFeedback and to check whether it retrieves feedback by vegetableId
	 * from the database
	 */
	@Test
	//@Disabled
	void testViewAllFeedbacks() {
		Feedback feedback1 = new Feedback(5, 10, "good");
		Feedback feedback2 = new Feedback(6, 10, "good");
		Vegetable vegetable = new Vegetable(1, "beans", "stem",70,60);
		feedback1.setVegetable(vegetable);;
		feedback2.setVegetable(vegetable);
		List<Feedback> FeedbackList = new ArrayList<>();
		FeedbackList.add(feedback1);
		FeedbackList.add(feedback2);
		Mockito.when(feedRep.findAll()).thenReturn(FeedbackList);
		List<Feedback> feed = feedService.viewAllFeedbacks(1);
		assertEquals(2, feed.size());
	}
	
	/**
	 * This below function is Mockito test case used to test the testDeleteFeedbackById and to check whether it deletes feedback by id
	 *  from the database
	 */
	@Test
	//@Disabled
	void testDeleteCustomerbyId() {
		Feedback feedback = new Feedback(5, 10, "good");
		Mockito.when(feedRep.findById(1)).thenReturn(Optional.of(feedback));
		feedRep.deleteById(1);
		Feedback persistedCust = feedService.deleteFeedbackById(1);
		assertEquals(5, persistedCust.getFeedbackId());
		
	}
	
	/**
	 * This below function is Mockito test case used to test the testViewList and to check whether it retrieves all feedback 
	 * from the database
	 */
	@Test
    //@Disabled
	void testViewList() {
		Feedback feedback1 = new Feedback(5, 10, "good");
		Feedback feedback2 = new Feedback(6, 10, "good");
		List<Feedback> FeedbackList = new ArrayList<>();
		FeedbackList.add(feedback1);
		FeedbackList.add(feedback2);
		Mockito.when(feedRep.findAll()).thenReturn(FeedbackList);
		List<Feedback> feedback = feedService.findAllFeedback();
		assertEquals(2, feedback.size());
	}
	
	}
