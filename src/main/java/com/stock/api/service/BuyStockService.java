package com.stock.api.service;

import com.stock.api.dto.CustomerStockRequestDTO;
import com.stock.api.dto.CustomerStockResponseDTO;

public interface BuyStockService {

	CustomerStockResponseDTO buyStock(CustomerStockRequestDTO customerStockRequestDTO);

}
