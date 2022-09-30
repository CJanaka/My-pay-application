package com.mypay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypay.model.Outlet;
import com.mypay.repository.OutletRepository;

@Service
public class OutletService {

	@Autowired
	private OutletRepository outleteRpository;
	//Add merchant's outlets.
	public Outlet addOutlet(Outlet outlet) {
		return outleteRpository.save(outlet);
	}
	
	public Outlet getOutletDetails(long outletId) {
		return outleteRpository.findById(outletId).get();
	}

}
