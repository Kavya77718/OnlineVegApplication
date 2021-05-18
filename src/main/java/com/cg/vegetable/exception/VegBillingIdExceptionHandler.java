package com.cg.vegetable.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.vegetable.module.VegErrorResponse;

@ControllerAdvice
public class VegBillingIdExceptionHandler{

	@ExceptionHandler
	public ResponseEntity<VegErrorResponse> handleException(VegBillingIdNotFoundException exception) {
		VegErrorResponse error = new VegErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<VegErrorResponse> handleException(Exception exception) {
		VegErrorResponse error = new VegErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value()); // 400
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	
}
}
