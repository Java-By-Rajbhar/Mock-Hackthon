package com.stock.api.util;

import org.springframework.stereotype.Component;

@Component
public class StockUtil {
	public static final String INVALID_USER_EXCEPTION = "Invalid user !!!!";

	public static final String INVALID_EMAIL_OR_PASSWORD = "Invalid email or password !!!";

	public static final String LOGIN_SUCCESS_MESSAGE = "Customer has logged in successfully";
	
	public static final String STOCK_EMPTY_EXCEPTION = "No Stocks Available";

	public Double stockTotalPrice(int quantity, Double stockPrice) {
		
		Double price = quantity * stockPrice;
		Double brokageAmount = (price * 10/100);
		Double totalPrice = price + brokageAmount;
		return totalPrice;
		
	}
}
