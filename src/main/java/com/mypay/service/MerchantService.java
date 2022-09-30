package com.mypay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypay.model.Merchant;
import com.mypay.repository.MerchantRepository;

@Service
public class MerchantService {

	@Autowired
	private MerchantRepository merchantRepository;
	
	public Merchant addMerchant(Merchant merchant) {
		return merchantRepository.save(merchant);
	}

}
