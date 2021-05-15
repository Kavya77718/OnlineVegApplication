package com.cg.vegetable.exception;

public class VegetableNotFoundException extends RuntimeException {

	public VegetableNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public VegetableNotFoundException(String message) {
		super(message);
		
	}

	public VegetableNotFoundException(Throwable cause) {
		super(cause);
		
	}

}
