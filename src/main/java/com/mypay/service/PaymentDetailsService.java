package com.mypay.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypay.model.Card;
import com.mypay.model.Counter;
import com.mypay.model.CustomerTransaction;
import com.mypay.model.Payment;
import com.mypay.model.PaymentDetails;
import com.mypay.repository.CustomerTransactionRepository;
import com.mypay.repository.PaymentRepository;

@Service
public class PaymentDetailsService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private CustomerTransactionRepository customerTransactionRepository;

	//PaymentDetails DTO class use to getting transaction details through the API.
	//This method use to store data to payment table and customerTransaction table at the same time.
	public boolean makeTransaction(PaymentDetails paymentDetails){
		boolean isSuccess = false;
		try {
			addPayment(paymentDetails);
			addTransaction(paymentDetails);
			isSuccess = true;
		} catch (Exception e) {
			isSuccess = false;
		}
		return isSuccess;
	}

	//This method store the data about payments. and not store the user's bank card details.
	public Payment addPayment(PaymentDetails paymentDetails) {
		Payment payment = new Payment();
		payment.setAmount(paymentDetails.getAmount());
		payment.setPaymentDate(LocalDate.now());
		Counter counter = new Counter();
		counter.setCounterId(paymentDetails.getCounterId());
		payment.setCounter(counter);
		return paymentRepository.save(payment);
	}

	//This method store the transactional details with bank card details.
	public CustomerTransaction addTransaction(PaymentDetails paymentDetails) {
		CustomerTransaction transaction = new CustomerTransaction();
		Card card = new Card();
		card.setCardId(paymentDetails.getCardId());
		transaction.setCard(card);
		transaction.setTransactionDate(LocalDate.now());
		transaction.setTransferTo(paymentDetails.getOutletName());
		transaction.setAmount(paymentDetails.getAmount());
		return customerTransactionRepository.save(transaction);
	}
}
