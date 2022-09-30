package com.mypay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypay.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
