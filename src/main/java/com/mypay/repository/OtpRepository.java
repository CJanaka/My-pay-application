package com.mypay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypay.model.OtpSMS;

public interface OtpRepository extends JpaRepository<OtpSMS, Long>{

	public OtpSMS findByContactNo(String contactNo);
	public void deleteByContactNo(String contactNo);
}
