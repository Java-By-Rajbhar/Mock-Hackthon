package com.stock.api.service;

import java.io.IOException;

import com.stock.api.dto.StockResponseDto;

public interface StockService {

	public StockResponseDto getStockTotalPrice(int customerId, int stockId, int quantity) throws IOException;
}
