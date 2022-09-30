package com.mypay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypay.model.Counter;

public interface CounterRepository extends JpaRepository<Counter, Long>{

}
