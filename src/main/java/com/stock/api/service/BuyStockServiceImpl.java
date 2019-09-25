package com.stock.api.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.stock.api.dto.CustomerStockRequestDTO;
import com.stock.api.dto.CustomerStockResponseDTO;
import com.stock.api.entity.CustomerStock;
import com.stock.api.entity.Stock;
import com.stock.api.exception.StockEmptyException;
import com.stock.api.repository.CustomerStockRepository;
import com.stock.api.repository.StockRepository;
import com.stock.api.util.StockUtil;

@Service
public class BuyStockServiceImpl implements BuyStockService {
	@Autowired
	CustomerStockRepository customerStockRepository;
	@Autowired
	StockUtil stockUtil;
	@Autowired
	StockRepository stockRepository;

	public CustomerStockResponseDTO buyStock(CustomerStockRequestDTO customerStockRequestDTO) {
		CustomerStockResponseDTO customerStockResponseDTO = new CustomerStockResponseDTO();
		CustomerStock customerStock = new CustomerStock();

		Optional<Stock> stock = stockRepository.findByStockId(customerStockRequestDTO.getStockId());
		if (stock.isPresent() && customerStockRequestDTO.getQuantity() < stock.get().getAvailableStocks()) {
			BeanUtils.copyProperties(customerStockRequestDTO, customerStock);
			customerStock.setPurchasedDate(LocalDate.now());
			customerStock.setStockName(stock.get().getStockName());
			customerStock.setTotalPrice(stockUtil.totalPrice(stock.get().getUnitPrice(), customerStock.getQuantity()));
			customerStockRepository.save(customerStock);
		} else {
			throw new StockEmptyException(StockUtil.INSUFFICIENT_STOCK_AVAILABLE_EXCEPTION);
		}

		customerStockResponseDTO.setMessage(StockUtil.STOCK_SUCCESS_MESSAGE);
		customerStockResponseDTO.setStatusCode(HttpStatus.CREATED.value());
		return customerStockResponseDTO;
	}

}
