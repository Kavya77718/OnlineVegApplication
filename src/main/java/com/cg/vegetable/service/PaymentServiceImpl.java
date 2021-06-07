package com.cg.vegetable.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vegetable.module.Payments;
import com.cg.vegetable.repository.IPaymentRepository;

@Service
public class PaymentServiceImpl implements IPaymentService{
	
	//Logger
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(PaymentServiceImpl.class);
		
	//AutoWiring the OrderServiceTest class to call down the service
	@Autowired
	IPaymentRepository payRepo;

	@Override
	public Payments addPayment(Payments payment) {
		logger.info("Adding payment details to the database");
		return payRepo.save(payment);
	}

	@Override
	public Payments findPaymentById(long paymentId) {
		logger.info("finding payment by id from the database");
		Optional<Payments> findpay = payRepo.findById(paymentId);
		if(!findpay.isPresent()) {
			return null;
		}
		return findpay.get();
	}

	@Override
	public List<Payments> findAllPayments() {
		logger.info("finding all payments from the database");
		return payRepo.findAll();
	}

	@Override
	public Payments save(Payments payment) {
		logger.info("saving or updating payment from the database");
		return payRepo.save(payment);
	}

	@Override
	public Payments deletePaymentById(long paymentId) {
		logger.info("deleting payment by id from the database");
		Optional<Payments> delPay = payRepo.findById(paymentId);
		if(!delPay.isPresent()) {
			return null;
		}
		payRepo.deleteById(paymentId);
		return delPay.get();
	}
	
}
