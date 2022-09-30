package com.mypay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Merchant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long merchantId;
	private int contactNo;
	private String email;
	private String merchantName;
	private String merchantAddress;
	
}
