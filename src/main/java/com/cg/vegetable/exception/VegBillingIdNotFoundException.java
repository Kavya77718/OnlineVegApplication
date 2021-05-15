package com.cg.vegetable.exception;

public class VegBillingIdNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 8191690097086138547L;
	public VegBillingIdNotFoundException(String message,Throwable cause) {
		super(message,cause);
	}
	public VegBillingIdNotFoundException(String message) {
		super(message);
	}
	public VegBillingIdNotFoundException(Throwable cause) {
		super(cause);
	
	}

}
