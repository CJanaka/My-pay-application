package com.mypay.service;

import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypay.model.OtpSMS;
import com.mypay.repository.OtpRepository;

@Service
public class OtpService {
	/*
	 * Tried to use third party service to send OTP code to phone but they no longer
	 * support for free service. I have Commented bellow code snippet that use to
	 * implements that SMS sending service.
	 */
	@Autowired
	private OtpRepository otpRepository;

//	@Autowired
//	private Configure otpConfig;

	public String sendOtpToUser(String contactNo) {
		/*
		 * Message message = null; try { PhoneNumber to = new PhoneNumber(contactNo);
		 * PhoneNumber from = new PhoneNumber(otpConfig.getTrialNumber()); String
		 * otpMessage = "Dear Customer , Your OTP is ##" + otp +
		 * "##. Use this Passcode to complete your transaction. Thank You."; message =
		 * Message.creator(to, from, otpMessage).create(); } catch (Exception ex) {
		 * System.out.println("Unsuccess"); }
		 */
		String otp = generateOTP();
		otpRepository.deleteByContactNo(contactNo);
		OtpSMS otpSms = new OtpSMS();
		otpSms.setContactNo(contactNo);
		otpSms.setOtpCode(otp);
		otpRepository.save(otpSms);
		return otp;
	}

	//Generate random OTP.
	public String generateOTP() {
		return new DecimalFormat("00000").format(new Random().nextInt(99999));
	}

	//Validate OTP and return boolean value whether the OTP is valid or not.
	public boolean validateOtp(OtpSMS otpSms) {
		OtpSMS otp = otpRepository.findByContactNo(otpSms.getContactNo());
		boolean isValidOtp = false;
		if (otpSms.getOtpCode().equalsIgnoreCase(otp.getOtpCode())) {
			return isValidOtp = true;
		}
		return isValidOtp;
	}
}
