package com.cg.vegetable.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vegetable.module.Payments;
import com.cg.vegetable.repository.IPaymentRepository;

@Service
public class PaymentServiceImpl implements IPaymentService{
	
	@Autowired
	IPaymentRepository payRepo;

	@Override
	public Payments addPayment(Payments payment) {
		return payRepo.save(payment);
	
	}

	@Override
	public Payments findPaymentById(long paymentId) {
		Optional<Payments> findpay = payRepo.findById(paymentId);
		if(!findpay.isPresent()) {
			return null;
		}
		return findpay.get();
	}

	@Override
	public List<Payments> findAllPayments() {
		return payRepo.findAll();
	}

	@Override
	public Payments save(Payments payment) {
		return payRepo.save(payment);
	}

	@Override
	public Payments deletePaymentById(long paymentId) {
		Optional<Payments> delPay = payRepo.findById(paymentId);
		if(!delPay.isPresent()) {
			return null;
		}
		payRepo.deleteById(paymentId);
		return delPay.get();
	}
	
}
