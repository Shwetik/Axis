package com.nlb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "a2loanapp")
public class LoanApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id;
	private String bankName;
	private Double requestedLoanAmount = 0.0;
	private Double termLength = 0.0;
	
	private Double minLoanAmount = 1000.0;
	private Double maxLoanAmount = 10000000.0;
	private Double minInterestRate = 0.05;
	private Double minCreditScore = 50.0;
	private Double processingFee = requestedLoanAmount * 0.001;
	private Rating rating = Rating.DECENT;
	private Status status = Status.PENDING;
	
	public LoanApplication() { super(); }

	public LoanApplication(Integer id, String bankName, Double requestedLoanAmount, Double termLength) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.requestedLoanAmount = requestedLoanAmount;
		this.termLength = termLength;
	}

	public LoanApplication(Integer id, String bankName, Double requestedLoanAmount, Double termLength,
			Double minLoanAmount, Double maxLoanAmount, Double minInterestRate, Double minCreditScore,
			Double processingFee, Rating rating, Status status) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.requestedLoanAmount = requestedLoanAmount;
		this.termLength = termLength;
		this.minLoanAmount = minLoanAmount;
		this.maxLoanAmount = maxLoanAmount;
		this.minInterestRate = minInterestRate;
		this.minCreditScore = minCreditScore;
		this.processingFee = processingFee;
		this.rating = rating;
		this.status = status;
	}

	@Override
	public String toString() {
		return "LoanApplication [id=" + id + ", bankName=" + bankName + ", requestedLoanAmount=" + requestedLoanAmount
				+ ", termLength=" + termLength + ", minLoanAmount=" + minLoanAmount + ", maxLoanAmount=" + maxLoanAmount
				+ ", minInterestRate=" + minInterestRate + ", minCreditScore=" + minCreditScore + ", processingFee="
				+ processingFee + ", rating=" + rating + ", status=" + status + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Double getRequestedLoanAmount() {
		return requestedLoanAmount;
	}

	public void setRequestedLoanAmount(Double requestedLoanAmount) {
		this.requestedLoanAmount = requestedLoanAmount;
	}

	public Double getTermLength() {
		return termLength;
	}

	public void setTermLength(Double termLength) {
		this.termLength = termLength;
	}

	public Double getMinLoanAmount() {
		return minLoanAmount;
	}

	public void setMinLoanAmount(Double minLoanAmount) {
		this.minLoanAmount = minLoanAmount;
	}

	public Double getMaxLoanAmount() {
		return maxLoanAmount;
	}

	public void setMaxLoanAmount(Double maxLoanAmount) {
		this.maxLoanAmount = maxLoanAmount;
	}

	public Double getMinInterestRate() {
		return minInterestRate;
	}

	public void setMinInterestRate(Double minInterestRate) {
		this.minInterestRate = minInterestRate;
	}

	public Double getMinCreditScore() {
		return minCreditScore;
	}

	public void setMinCreditScore(Double minCreditScore) {
		this.minCreditScore = minCreditScore;
	}

	public Double getProcessingFee() {
		return processingFee;
	}

	public void setProcessingFee(Double processingFee) {
		this.processingFee = processingFee;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
