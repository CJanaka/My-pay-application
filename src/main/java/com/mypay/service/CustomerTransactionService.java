package com.mypay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypay.model.CustomerTransaction;
import com.mypay.repository.CustomerTransactionRepository;

@Service
public class CustomerTransactionService {

	@Autowired
	CustomerTransactionRepository customerTransactionRepository;
	
	//Get customer's all transaction details
	public List<CustomerTransaction> getTransactionDetails(long customerId) {
		return customerTransactionRepository.findAllByCardCustomerCustomerId(customerId);
	}
}
