package com.cg.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.main.entities.Customer;
import com.cg.main.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
//add a transaction 
//get last 5 transaction
	//public List<transaction> getTransactionByAccNo(int accNo);
   public Customer findByCustomerAccNo(int accNo);   //get  a list of transaction given the accNo  
   public List<Transaction> findByFromAcc(int accNO);
   public List<Transaction> findByToAcc(int accNo);
   }
