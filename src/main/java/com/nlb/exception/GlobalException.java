package com.nlb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value = LoanApplicationAlreadyExistsException.class)
	public ResponseEntity<Object> alreadyExists(LoanApplicationAlreadyExistsException exception) {
		return new ResponseEntity<Object>("Loan Application Already Exists", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(value = LoanApplicationNotFoundException.class)
	public ResponseEntity<Object> notFound(LoanApplicationNotFoundException exception) {
		return new ResponseEntity<Object>("Could Not Find The Loan Application", HttpStatus.NOT_FOUND);
	}

}
