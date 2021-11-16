package com.nlb.exception;

public class LoanApplicationAlreadyExistsException extends RuntimeException {

	static final long serialVersionUID = 1L;
	String msg;

	public LoanApplicationAlreadyExistsException(String msg) {
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
