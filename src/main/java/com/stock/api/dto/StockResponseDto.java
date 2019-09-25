package com.stock.api.dto;

import java.io.Serializable;

public class StockResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private int stockId;
	private int quantity;
	private int statusCode;
	private Double totalPrice;
	
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
