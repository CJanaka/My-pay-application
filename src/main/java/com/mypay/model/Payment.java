package com.mypay.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long paymentId;
	private LocalDate paymentDate;
	private double amount;
	@ManyToOne(fetch= FetchType.LAZY)
	private Counter counter;
}
