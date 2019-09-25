package com.stock.api.service;

import java.util.List;

import com.stock.api.dto.CustomerStockResDto;

public interface CustomerStockService {

	List<CustomerStockResDto> getPurchasedStocks(Integer customerId);

}
