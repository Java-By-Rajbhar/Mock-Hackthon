package com.stock.api.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stock.api.repository.StockRepository;
import com.stock.api.util.StockUtil;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.stock.api.dto.StockPriceResponseDto;
import com.stock.api.dto.StockResponseDTO;
import com.stock.api.entity.Stock;
import com.stock.api.exception.StockEmptyException;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StockServiceImpl implements StockService {
	
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	StockRepository stockRepository;
	@Autowired
	StockUtil stockUtil;

	@Override
	public StockPriceResponseDto getStockTotalPrice(int customerId, int stockId, int quantity) throws IOException {
		
		String stockName = stockRepository.findByStockId(stockId).getStockName();

		String apiResponse =restTemplate.exchange("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + stockName
				+ "&apikey=JX52QBGWV5X1C7YA", HttpMethod.GET, null, new ParameterizedTypeReference<String>() { },
				  stockName).getBody();
		
		  ObjectMapper mapper = new ObjectMapper();
		  JsonNode response = mapper.readTree(apiResponse);

		Double latestStockPrice = response.get("Global Quote").get("05. price").asDouble();
	
		Double totalStockPrice = stockUtil.stockTotalPrice(quantity, latestStockPrice);
		
		StockPriceResponseDto stockPriceResponseDto = new StockPriceResponseDto();
		stockPriceResponseDto.setTotalPrice(totalStockPrice);
		stockPriceResponseDto.setQuantity(quantity);
		stockPriceResponseDto.setStatusCode(200);
		stockPriceResponseDto.setStockId(stockId);
		
		return stockPriceResponseDto;
	}
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


