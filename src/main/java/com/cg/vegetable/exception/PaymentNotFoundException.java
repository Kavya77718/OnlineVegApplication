package com.cg.vegetable.exception;

public class PaymentNotFoundException extends RuntimeException {

		public PaymentNotFoundException(String message, Throwable cause) {
			super(message, cause);
		}

		public PaymentNotFoundException(String message) {
			super(message);
		}

		public PaymentNotFoundException(Throwable cause) {
			super(cause);
		}

}