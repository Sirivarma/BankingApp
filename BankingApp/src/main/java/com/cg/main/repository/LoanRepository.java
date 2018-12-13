package com.cg.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.main.entities.Customer;
import com.cg.main.entities.Loan;


public interface LoanRepository extends JpaRepository<Loan, Integer> {
	 public Customer findByCustomerAccNo(int accNo);
}
