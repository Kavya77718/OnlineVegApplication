package com.cg.vegetable.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vegetable.module.Address;
import com.cg.vegetable.module.Customer;
import com.cg.vegetable.module.Feedback;

@SpringBootTest
public class FeedbackServiceImplTest {
	

	@Autowired
	IFeedbackService feedService;
	
	@Test
	@Disabled
	void  testAddFeedback() {
		Feedback feedback = new Feedback(5, 10, "good");
		Customer customer1 = new Customer(1,"Kavya", "886535214", "abcd@g.com");
		feedback.setCustomer(customer1);
		Feedback persistedCust =  feedService.addFeedback(feedback);
		assertEquals(10, persistedCust.getRating());
    }
	
	@Test
	@Disabled
	void testViewFeedback() {
		List<Feedback> feed = feedService.viewFeedback(1);
		assertEquals(2, feed.size());
	}
	
	@Test
	@Disabled
	void testViewAllFeedback() {
		List<Feedback> feed = feedService.viewAllFeedbacks(20);
		assertEquals(1, feed.size());
	}	
	

}
