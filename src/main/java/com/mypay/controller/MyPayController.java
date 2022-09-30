package com.mypay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypay.model.Card;
import com.mypay.model.Counter;
import com.mypay.model.Customer;
import com.mypay.model.CustomerTransaction;
import com.mypay.model.Merchant;
import com.mypay.model.OtpSMS;
import com.mypay.model.Outlet;
import com.mypay.model.PaymentDetails;
import com.mypay.service.CardService;
import com.mypay.service.CounterService;
import com.mypay.service.CustomerService;
import com.mypay.service.CustomerTransactionService;
import com.mypay.service.MerchantService;
import com.mypay.service.OtpService;
import com.mypay.service.OutletService;
import com.mypay.service.PaymentDetailsService;

@RestController
@RequestMapping("/api/v1")
public class MyPayController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private OtpService otpService;

	@Autowired
	private PaymentDetailsService paymentDetailsService;

	@Autowired
	private CustomerTransactionService customerTransactionService;
	
	@Autowired
	private CardService cardService;

	@Autowired
	private OutletService outletService;

	@Autowired
	private CounterService counterService;

	@Autowired
	private MerchantService merchantService;

	//Get contact number and sent OTP.
	@GetMapping("/{contact}")
	public String sendOTP(@PathVariable("contact") String contactNo) {
		return otpService.sendOtpToUser(contactNo);
	}

	//Check and verify OTP. 
	@PostMapping("/otp")
	public ResponseEntity<String> validateOTP(@RequestBody OtpSMS otpSms) {
		if (otpService.validateOtp(otpSms)) {
			return ResponseEntity.status(HttpStatus.OK).body("Valid OTP");
		}
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Invalid OTP!");
	}

	@PostMapping("/add-customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}

	@PostMapping("/add-merchant")
	public Merchant addMerchant(@RequestBody Merchant merchant) {
		return merchantService.addMerchant(merchant);
	}
	
	@PostMapping("/add-outlet")
	public Outlet addOutlet(@RequestBody Outlet outlet) {
		return outletService.addOutlet(outlet);
	}

	@PostMapping("/add-counter")
	public Counter addCounter(@RequestBody Counter counter) {
		return counterService.addCounter(counter);
	}
	
	@PostMapping("/add-card")
	public Card addCard(@RequestBody Card card) {
		return cardService.addCard(card);
	}

	//Get payments and process them.
	@PostMapping("/pay")
	public ResponseEntity<String> makePayment(@RequestBody PaymentDetails paymentDetails) {
		if (paymentDetailsService.makeTransaction(paymentDetails)) {
			return ResponseEntity.status(HttpStatus.OK).body("Transaction Successful!");
		}
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Transaction Failed!");
	}

	@GetMapping("/outlet/{id}")
	public Outlet getMerchantOutletDetails(@PathVariable("id") long outletId) {
		return outletService.getOutletDetails(outletId);
	}

	@GetMapping("/get-cards")
	public List<Card> getAllCardDetails() {
		return cardService.getAllCardDetails();
	}
	
	@GetMapping("/get-card/{id}")
	public Card getCardDetails(@PathVariable("id") long cardId) {
		return cardService.getCardDetails(cardId);
	}
	
	//Return customer's all transactional details
	@GetMapping("/transaction/{id}")
	public List<CustomerTransaction> getTransactionDetails(@PathVariable("id") long customerId) {
		return customerTransactionService.getTransactionDetails(customerId);
	}
	
	@PutMapping("/{id}")
	public Card updateBankCardDetails(@PathVariable("id") long cardId, @RequestBody Card card) {
		return cardService.updateCardDetails(card, cardId);
	}

	@PutMapping("/update-customer/{id}")
	public void updateCustomerDetails(@PathVariable("id") long customerId, @RequestBody Customer customer) {
		customerService.updateCustomer(customer, customerId);
	}
}
