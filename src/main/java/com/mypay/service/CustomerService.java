package com.mypay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypay.model.Customer;
import com.mypay.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer updateCustomer(Customer customer, long customerId) {
		Customer existingCustomer = customerRepository.findById(customerId).get();
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setContactNo(customer.getContactNo());
		existingCustomer.setDateOfBirth(customer.getDateOfBirth());
		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		existingCustomer.setNicNumber(customer.getNicNumber());
		return customerRepository.save(existingCustomer);
	}

}
