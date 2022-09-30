package com.mypay.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cardId;
	private String cardHolderName;
	@Column(length = 1000)
	private String cardNumber;
	private int cardCsv;
	private Date expirationDate;
	@ManyToOne
	private Customer customer;
}
