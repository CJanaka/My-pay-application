package com.mypay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypay.model.CustomerTransaction;


public interface CustomerTransactionRepository extends JpaRepository<CustomerTransaction, Long>{

	public List<CustomerTransaction> findAllByCardCustomerCustomerId(long customerId);
	
}
