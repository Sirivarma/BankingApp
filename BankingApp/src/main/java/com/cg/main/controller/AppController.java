package com.cg.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.main.entities.Customer;
import com.cg.main.entities.Loan;
import com.cg.main.entities.Transaction;
import com.cg.main.service.CustomerService;
import com.cg.main.service.LoanService;
import com.cg.main.service.TransactionService;

@RestController
public class AppController {
	
@Autowired
private CustomerService customerService;


	
@RequestMapping("/customer/{accNo}")    
public Customer getCustomerDetails(@PathVariable int accNo) throws Exception {
	 
		return customerService.getCustomer(accNo);
	
	}   

@RequestMapping("/customer")    
public List<Customer> getAllCustomers() throws Exception {
	return customerService.getAllCustomers();
	} 
	
@RequestMapping(method= RequestMethod.POST, value="/customer")
public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws Exception {
	Customer customeradded = customerService.addCustomer(customer);
	
		return new ResponseEntity<Customer>(customeradded, HttpStatus.OK);

	}

@RequestMapping(method= RequestMethod.DELETE, value ="/customer/{accNo}")
public void deleteCustomer(@PathVariable int accNo) throws Exception {
	customerService.deleteCustomer(accNo);
	}

@RequestMapping(method= RequestMethod.PUT, value ="/customer/{accNo}" )
public void updateCustomer(@RequestBody Customer customer, @PathVariable int accNo) throws Exception {
	customerService.updateCustomer(accNo, customer);
	}


@RequestMapping("/balance/{accNo}")    
public double getBalance(@PathVariable int accNo) throws Exception {
	return customerService.getBalance(accNo);
	} 

//*************************************Transaction Calls**************************************************///
@Autowired
private TransactionService transactionService;

@RequestMapping(value= "/customer/{accNo}/transfer" ,method=RequestMethod.POST)
public Transaction addTransaction (@RequestBody Transaction transaction, @PathVariable int accNo) throws Exception
{
	return  transactionService.newTransacton(transaction, accNo);  
}

/**gives list of transaction given the account number*/
@RequestMapping(value= "/customer/{accNo}/transaction" ,method=RequestMethod.GET) 
public List<Transaction> getAllTransaction(@PathVariable int accNo)throws Exception{
	return transactionService.getAllTransaction(accNo);
}

//**************************************Loans *******************************************************
@Autowired
private LoanService loanService;

@RequestMapping(value= "/customer/{accNo}/applyloan" ,method=RequestMethod.POST)
public Loan addLoanRequest(@RequestBody Loan loan, @PathVariable int accNo) throws Exception {
	return loanService.newLoan(loan, accNo);
}












}















