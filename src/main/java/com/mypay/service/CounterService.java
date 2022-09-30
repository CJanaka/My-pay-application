package com.mypay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypay.model.Counter;
import com.mypay.repository.CounterRepository;

@Service
public class CounterService {

	@Autowired
	private CounterRepository counterRepository;
	
	//Add counters for outlet.
	public Counter addCounter(Counter counter) {
		return counterRepository.save(counter);
	}

}
