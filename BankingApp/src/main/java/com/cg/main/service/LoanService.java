package com.cg.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.main.entities.Customer;
import com.cg.main.entities.Loan;
import com.cg.main.repository.LoanRepository;

@Service
public class LoanService {

@Autowired
LoanRepository loanRepository;




public Loan newLoan(Loan loan, int accNo) {
      Customer customer =loanRepository.findByCustomerAccNo(accNo);
      if(customer != null)
      {
    	  loanRepository.save(loan);
      }
	return null;
      
}




}
