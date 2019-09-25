package com.stock.api.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.api.dto.StockResponseDTO;
import com.stock.api.entity.Stock;
import com.stock.api.exception.StockEmptyException;
import com.stock.api.repository.StockRepository;
import com.stock.api.util.StockUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepository;

	public List<StockResponseDTO> viewAllStocks() {
		List<Stock> listOfStocks = stockRepository.findAll();
		log.info("inside view all stocks of Service Implementation class");

		List<StockResponseDTO> listOfResponseStocks = new ArrayList<>();
		if (listOfStocks.isEmpty()) {
			throw new StockEmptyException(StockUtil.STOCK_EMPTY_EXCEPTION);

		}
		else {
			for (Stock eachStock : listOfStocks) {
				StockResponseDTO stockResponseDTO= new StockResponseDTO();
				BeanUtils.copyProperties(eachStock, stockResponseDTO);
				listOfResponseStocks.add(stockResponseDTO);
				
				
			}
		}

		return listOfResponseStocks;
	}

}
