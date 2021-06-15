package com.cg.vegetable.service;

import java.util.List;

import com.cg.vegetable.module.OrderDet;
import com.cg.vegetable.module.Payments;


public interface IPaymentService {
	 public Payments addPayment(Payments payment);
	 public Payments findPaymentById(long paymentId);
	 public List<Payments> findAllPayments();
	 public Payments save(Payments payment);
	 public Payments deletePaymentById(long paymentId); 
	 public Payments addPayment1(int orderNo,Payments payment);
	 
}
