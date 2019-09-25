package com.stock.api.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerStockResDto {

	private Integer stockId;
	private String stockName;
	private Integer quantity;
	private Double totalPrice;
	private LocalDate purchasedDate;
}
