package com.mypay.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetails {

	private long counterId;
	private String outletName;
	private double amount;
	private long cardId;
	
}
