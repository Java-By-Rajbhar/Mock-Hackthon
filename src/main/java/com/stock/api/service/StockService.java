package com.stock.api.service;

import java.util.List;

import com.stock.api.dto.StockResponseDTO;

public interface StockService {

	List<StockResponseDTO> viewAllStocks();

}
