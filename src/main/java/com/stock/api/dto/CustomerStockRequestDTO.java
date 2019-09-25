package com.stock.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerStockRequestDTO {

	private Integer stockId;
	private Integer quantity;
	private Integer customerId;
	private Double totalPrice;

}
