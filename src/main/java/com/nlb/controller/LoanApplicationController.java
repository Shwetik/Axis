package com.nlb.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlb.entity.LoanApplication;
import com.nlb.exception.LoanApplicationAlreadyExistsException;
import com.nlb.exception.LoanApplicationNotFoundException;
import com.nlb.service.ILoanApplicationService;

@RestController
@RequestMapping(value = "/loanService")
public class LoanApplicationController {
	
	@Autowired
	ILoanApplicationService service;
	
	@PostMapping(value = "/apply")
	public ResponseEntity<Object> applyLoan(@RequestBody LoanApplication requestLoanApp) {
		try {
			service.view(requestLoanApp.getId());
			throw new LoanApplicationAlreadyExistsException("Apply Not Possible: Loan Id Already Exists");
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Object>(service.save(requestLoanApp), HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/viewStatus/{loanId}")
	public ResponseEntity<Object> getLoanStatus(@PathVariable int loanId) {
		try {
			return new ResponseEntity<Object>(service.view(loanId), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			throw new LoanApplicationNotFoundException("Loan Applicaiton Doesn Not Exist");
		}
	}
	
	@GetMapping(value = "/approve/{loanId}")
	public ResponseEntity<Object> approveLoan(@PathVariable Integer loanId) {
		try {
			service.view(loanId);
			return new ResponseEntity<Object>(service.approve(loanId), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			throw new LoanApplicationNotFoundException("Loan Applicaiton Doesn Not Exist");
		}
	}
	
	@GetMapping(value = "/reject/{loanId}")
	public ResponseEntity<Object> rejectLoan(@PathVariable Integer loanId) {
		try {
			service.view(loanId);
			return new ResponseEntity<Object>(service.reject(loanId), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			throw new LoanApplicationNotFoundException("Loan Applicaiton Doesn Not Exist");
		}
	}
	
}
