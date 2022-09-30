package com.mypay.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypay.model.Card;
import com.mypay.repository.CardRepository;

@Service
public class CardService {

	@Autowired
	private CardRepository cardRepository;

	public Card addCard(Card cardDetails) {
		System.out.println(cardNumberEncoder(cardDetails.getCardNumber()));
		cardDetails.setCardNumber(cardNumberEncoder(cardDetails.getCardNumber()));
		return cardRepository.save(cardDetails);
	}
	
	public Card getCardDetails(long cardId) {
		Card card  = cardRepository.findById(cardId).get();
		card.setCardNumber(cardNumberDecoder(card.getCardNumber()));
		return card;	
	}
	
	public List<Card> getAllCardDetails() {
		List<Card> card = cardRepository.findAll();
		for (Card bankCard : card) {
			bankCard.setCardNumber(cardNumberDecoder(bankCard.getCardNumber()));
		}
		return card;
	}
	
	//Encode bank card number and return encoded string.
	private String cardNumberEncoder(String cardNo) {
    	return Base64.getEncoder().encodeToString(cardNo.getBytes());
    }
    
	//Decode bank card number and return Decode bank card number.
	private String cardNumberDecoder(String encodedCardNo) {
    	byte[] byteArray = Base64.getDecoder().decode(encodedCardNo);
    	return new String(byteArray);
    }

	public Card updateCardDetails(Card card, long cardId) {
		Card existingCardDetails = cardRepository.findById(cardId).get();
		existingCardDetails.setCardCsv(card.getCardCsv());
		existingCardDetails.setCardHolderName(card.getCardHolderName());
		existingCardDetails.setCardNumber(card.getCardNumber());
		existingCardDetails.setExpirationDate(card.getExpirationDate());
		return cardRepository.save(existingCardDetails);
	} 
}
