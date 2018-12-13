package com.cg.main.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.main.entities.Customer;
import com.cg.main.repository.CustomerRepository;




@Service
public class CustomerService {
@Autowired	
private CustomerRepository customerRepository;
	
//getCustomer( accNo)
//updateCustomer(Customer c)
//deleteCustomer(accNo)
//getBalance(accNo)
//addCustomer( Customer c )

public boolean validateAccNo(int accNo){
	Customer customer = customerRepository.findOne(accNo);
	if(customer!= null)
		return true;
	else
	return false;
	}
		
public Customer getCustomer(int accNo) {
	
	if( validateAccNo(accNo))
	return customerRepository.getOne(accNo);
	else return null;
	}

public Customer addCustomer(Customer customer) {
	String dob = customer.getDob();
	int age = calAge(dob);
	customer.setAge(age);
	return customerRepository.save(customer);
	}

public void deleteCustomer(int accNo) {
	if(validateAccNo(accNo))
	customerRepository.delete(accNo);
}



public List<Customer> getAllCustomers() {

	return customerRepository.findAll();
	}

public void updateCustomer(int accNo, Customer customer) {
	customerRepository.save(customer);
	}

public int calAge(String dob) {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
	LocalDate dob1 = LocalDate.parse(dob, formatter);
	LocalDate now = LocalDate.now();
	Period period = Period.between(dob1, now);
	return period.getYears();
}

public double getBalance(int accNo) {
	if(validateAccNo(accNo)) 
		return customerRepository.findOne(accNo).getBalance();
	else
	return (Double) null;
	
	
}
}


