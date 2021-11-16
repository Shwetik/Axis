package com.nlb.service;

import com.nlb.entity.LoanApplication;

public interface ILoanApplicationService {

	public LoanApplication save(LoanApplication loanApp);
	public LoanApplication view(Integer loanId);
	public LoanApplication approve(Integer loanId);
	public LoanApplication reject(Integer loanId);

}
