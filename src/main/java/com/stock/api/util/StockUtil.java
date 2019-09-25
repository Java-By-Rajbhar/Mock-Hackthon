package com.stock.api.util;

import org.springframework.stereotype.Component;

@Component
public class StockUtil {
	
	public static final  String INVALID_CUSTOMER_EXCEPTION="No purchased history available ";
	public static final  String CUSTOMER_NOT_FOUND_EXCEPTION="No customer Avilable";
	public static final String INVALID_USER_EXCEPTION = "Invalid user !!!!";

	public static final String INVALID_EMAIL_OR_PASSWORD = "Invalid email or password !!!";
	public static final String INSUFFICIENT_STOCK_AVAILABLE_EXCEPTION="Please provide lesser quantity";
	public static final String LOGIN_SUCCESS_MESSAGE = "Customer has logged in successfully";
	public static final String STOCK_SUCCESS_MESSAGE="Stock bought successfully ";
	public static final String STOCK_EMPTY_EXCEPTION = "No Stocks Available";
	public Double totalPrice(Double price,Integer quantity) {
		Double totalprice=quantity*price;
		Double brokage=(totalprice/100)*10;
	
		return totalprice+brokage;
		
	}

	public Double stockTotalPrice(int quantity, Double stockPrice) {
		
		Double price = quantity * stockPrice;
		Double brokageAmount = (price * 10/100);
		Double totalPrice =price + brokageAmount;

		return  Math.round(totalPrice * 100.0) / 100.0;
		
	}
}
