package com.nlb.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlb.entity.LoanApplication;
import com.nlb.entity.Status;
import com.nlb.repository.ILoanApplicationRepository;

@Service
public class LoanApplicationService implements ILoanApplicationService {

	@Autowired
	ILoanApplicationRepository repo;
	
	@Override
	public LoanApplication save(LoanApplication loanApp) {
		repo.save(loanApp);
		return loanApp;
	}
	
	@Override
	public LoanApplication view(Integer loanId) throws NoSuchElementException {
		return repo.findById(loanId).get();
	}

	@Override
	public LoanApplication approve(Integer loanId) throws NoSuchElementException {
		LoanApplication loanApp = view(loanId);
		loanApp.setStatus(Status.ACCEPTED);
		repo.save(loanApp);
		return loanApp;
	}

	@Override
	public LoanApplication reject(Integer loanId) throws NoSuchElementException {
		LoanApplication loanApp = view(loanId);
		loanApp.setStatus(Status.REJECTED);
		repo.save(loanApp);
		return loanApp;
	}
}
