package com.mypay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypay.model.Card;

public interface CardRepository extends JpaRepository<Card, Long>{

}
