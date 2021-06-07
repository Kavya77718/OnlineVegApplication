package com.cg.vegetable.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.vegetable.module.CartErrorMessage;

@ControllerAdvice
public class CartExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<CartErrorMessage> handleException(CartNotFoundException e) {
		CartErrorMessage error = new CartErrorMessage();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<CartErrorMessage> handleException(Exception e) {
		CartErrorMessage error = new CartErrorMessage();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("ENTER THE VALID ID");
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
