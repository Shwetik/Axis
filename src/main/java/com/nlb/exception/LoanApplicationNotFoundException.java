package com.nlb.exception;

public class LoanApplicationNotFoundException extends RuntimeException {

	static final long serialVersionUID = 1L;
	String msg;

	public LoanApplicationNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
