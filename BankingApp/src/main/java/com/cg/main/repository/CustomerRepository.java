package com.cg.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.main.entities.Customer;



public interface CustomerRepository extends JpaRepository<Customer,Integer>{



	//getCustomer( accNo)
	//updateCustomer(Customer t)
	//deleteCustomer(accNo)
	//getBalance(accNo)
	//addCustomer()
	
}
