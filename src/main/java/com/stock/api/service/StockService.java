package com.stock.api.service;

import java.io.IOException;
import java.util.List;

import com.stock.api.dto.StockPriceResponseDto;
import com.stock.api.dto.StockResponseDTO;

public interface StockService {

	public StockPriceResponseDto getStockTotalPrice(int customerId, int stockId, int quantity) throws IOException;


	List<StockResponseDTO> viewAllStocks();


	public StockResponseDTO getParticualarStock(Integer stockId);

}
