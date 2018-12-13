package com.cg.main.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties("handler")
@SequenceGenerator(name="seqT",sequenceName = "seqT", initialValue= 100000, allocationSize=100)
public class Loan {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqT")
private int loansId;
private int loanType;
private int amount;
private double rate;
private double period;
private double emi;

@ManyToOne(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
@JoinColumn(name ="accNo")
private Customer customer;

public int getLoansId() {
	return loansId;
}

public void setLoansId(int loansId) {
	this.loansId = loansId;
}

public int getLoanType() {
	return loanType;
}

public void setLoanType(int loanType) {
	this.loanType = loanType;
}

public int getAmount() {
	return amount;
}

public void setAmount(int amount) {
	this.amount = amount;
}

public double getRate() {
	return rate;
}

public void setRate(double rate) {
	this.rate = rate;
}

public double getPeriod() {
	return period;
}

public void setPeriod(double period) {
	this.period = period;
}

public double getEmi() {
	return emi;
}

public void setEmi(double emi) {
	this.emi = emi;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}




}
