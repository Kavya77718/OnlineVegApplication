package com.cg.vegetable.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.vegetable.module.FeedbackErrorResponse;

@ControllerAdvice
public class FeedbackExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<FeedbackErrorResponse> handleException(FeedbackNotFoundException exception) {
		FeedbackErrorResponse error = new FeedbackErrorResponse();	
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());	
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<FeedbackErrorResponse> handleException(Exception exception) {
		FeedbackErrorResponse error = new FeedbackErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value()); // 400
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}