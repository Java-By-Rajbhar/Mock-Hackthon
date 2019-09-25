package com.stock.api.util;

import org.springframework.stereotype.Component;

@Component
public class StockUtil {

	public Double stockTotalPrice(int quantity, Double stockPrice) {
		
		Double price = quantity * stockPrice;
		Double brokageAmount = (price * 10/100);
		Double totalPrice = price + brokageAmount;
		return totalPrice;
		
	}
}
