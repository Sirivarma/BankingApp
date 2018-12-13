package com.cg.main.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.main.entities.Customer;
import com.cg.main.entities.Transaction;
import com.cg.main.repository.CustomerRepository;
import com.cg.main.repository.TransactionRepository;


@Service
public class TransactionService {
    @Autowired
	private TransactionRepository transactionRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    public boolean validateAccNo(int accNo) {
    	Customer customer = customerRepository.findOne(accNo);
    	if(customer!= null)
    		return true;
    	else
    	return false;
    	}

	public Transaction newTransacton(Transaction transaction, int accNo) {
		
		Customer debitCustomer = customerRepository.findOne(accNo);
		if (debitCustomer == null)
			return null;
		else {
			int transAmt =transaction.getTransAmt();
			double dBalance = debitCustomer.getBalance();
			int dMinBalance = debitCustomer.getMinBalance();
			Customer creditCustomer = customerRepository.findOne(transaction.getToAcc());
		
			if((dBalance- dMinBalance)>= transAmt) 
			{  
				transaction.setFromAcc(accNo);
				transaction.setTransType("debit");
				transaction.setTransDate(LocalDateTime.now());
				if(creditCustomer != null)    // if the benificary belongs to the same bank
					creditCustomer.setBalance((creditCustomer.getBalance())+ transAmt);
				
				debitCustomer.setBalance(dBalance-transAmt);
				transaction.setCustomer(debitCustomer);
				
				
				return transactionRepository.save(transaction) ;
			}
			else
				return null;
	}}
	
	/**gives list of transaction given the account number*/
	public List<Transaction> getAllTransaction(int accNo){
		if(validateAccNo(accNo)) {
         Customer customer = transactionRepository.findByCustomerAccNo(accNo);  
                    
		 List<Transaction>listOfCreditTransaction= transactionRepository.findByToAcc(accNo);
		 for(Transaction obj : listOfCreditTransaction ) {
			 obj.setTransType("credit");
			 obj.setCustomer(customer);
		 }
		 List<Transaction>listOfDebitTransaction= transactionRepository.findByFromAcc(accNo);
		 
		 List<Transaction>listOfTransaction = new ArrayList<Transaction>();
		 listOfTransaction.addAll(listOfDebitTransaction);
		 listOfTransaction.addAll(listOfCreditTransaction);
		 return listOfTransaction;
		}
		else 
			return null;
		

	}
	/****get-tranactionDetails given the transactionId****/
	
	
}
