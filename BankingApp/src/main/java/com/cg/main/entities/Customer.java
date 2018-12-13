package com.cg.main.entities;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SequenceGenerator(name="seq",sequenceName = "seq", initialValue= 100000, allocationSize=10112000)
public class Customer {
@Id	
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
private int accNo;	
private String fName;
private String lName;
private String accType;
private String panNo;
private String addharNo;
private String phoneNo;
private String dob;
private int age;
private double balance;
private int minBalance;
@ElementCollection
private List<Address> listOfAddress = new ArrayList<Address>();

public List<Address> getListOfAddress() {
	return listOfAddress;
}
public void setListOfAddress(List<Address> listOfAddress) {
	this.listOfAddress = listOfAddress;
}

public int getAccNo() {
	return accNo;
}

public void setAccNo(int accNo) {
	this.accNo = accNo;
}

public String getfName() {
	return fName;
}

public void setfName(String fName) {
	this.fName = fName;
}

public String getlName() {
	return lName;
}

public void setlName(String lName) {
	this.lName = lName;
}

public String getAccType() {
	return accType;
}

public void setAccType(String accType) {
	this.accType = accType;
}

public String getPanNo() {
	return panNo;
}

public void setPanNo(String panNo) {
	this.panNo = panNo;
}

public String getPhoneNo() {
	return phoneNo;
}

public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}

public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
}

public int getAge() {
	return age;
}

public void setAge(int age)  {
	this.age = age;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

public int getMinBalance() {
	return minBalance;
}

public void setMinBalance(int minBalance) {
	this.minBalance = minBalance;
}

public String getAddharNo() {
	return addharNo;
}

public void setAddharNo(String addharNo) {
	this.addharNo = addharNo;
}






}
