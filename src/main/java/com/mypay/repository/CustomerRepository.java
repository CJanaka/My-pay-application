package com.mypay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypay.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	public Customer findByContactNo(String contactNo);
}
