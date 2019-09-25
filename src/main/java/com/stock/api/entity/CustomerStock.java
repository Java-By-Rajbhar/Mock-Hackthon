package com.stock.api.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CustomerStock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer purchasedId;
	private Integer stockId;
	private String stockName;
	private Integer customerId;
	private Integer quantity;
	private Double totalPrice;
	private LocalDate purchasedDate;
}
