package com.stock.api.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stock.api.dto.StockResponseDto;
import com.stock.api.repository.StockRepository;
import com.stock.api.util.StockUtil;

@Service
public class StockServiceImpl implements StockService {
	
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	StockRepository stockRepository;
	@Autowired
	StockUtil stockUtil;

	@Override
	public StockResponseDto getStockTotalPrice(int customerId, int stockId, int quantity) throws IOException {
		
		String stockName = stockRepository.findByStockId(stockId).getStockName();

		String apiResponse =restTemplate.exchange("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + stockName
				+ "&apikey=JX52QBGWV5X1C7YA", HttpMethod.GET, null, new ParameterizedTypeReference<String>() { },
				  stockName).getBody();
		
		  ObjectMapper mapper = new ObjectMapper();
		  JsonNode response = mapper.readTree(apiResponse);

		Double latestStockPrice = response.get("Global Quote").get("05. price").asDouble();
	
		Double totalStockPrice = stockUtil.stockTotalPrice(quantity, latestStockPrice);
		
		StockResponseDto stockResponseDto = new StockResponseDto();
		stockResponseDto.setTotalPrice(totalStockPrice);
		stockResponseDto.setQuantity(quantity);
		stockResponseDto.setStatusCode(200);
		stockResponseDto.setStockId(stockId);
		
		return stockResponseDto;
	}

}
