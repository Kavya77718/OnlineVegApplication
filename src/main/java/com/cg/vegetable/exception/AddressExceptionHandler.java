package com.cg.vegetable.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.vegetable.module.AddressErrorResponse;

@ControllerAdvice
public class AddressExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<AddressErrorResponse> handleException(AddressNotFoundException exception) {
		AddressErrorResponse error = new AddressErrorResponse();	
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());	
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<AddressErrorResponse> handleException(Exception exception) {
		AddressErrorResponse error = new AddressErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value()); // 400
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
