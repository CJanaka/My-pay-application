package com.mypay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypay.model.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Long>{

}
