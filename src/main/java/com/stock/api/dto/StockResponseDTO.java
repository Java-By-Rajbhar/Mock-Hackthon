package com.stock.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class StockResponseDTO {
	private Integer stockId;
	private String stockName;
	private Double unitPrice;
	private String description;
}
