package com.stock.api.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.stock.api.dto.StockResponseDto;
import com.stock.api.service.StockService;

@RestController
public class StockController {
	
	@Autowired
	StockService stockService;

	@GetMapping("/api/customers/{customerId}/stocks/{stockId}/{quantity}")
//	public Double getStockPrice(@PathVariable String stockName)
	public ResponseEntity<StockResponseDto> getStockPrice(@PathVariable int customerId, @PathVariable int stockId, @PathVariable int quantity) throws IOException 
	{
		StockResponseDto latestStockPrice = stockService.getStockTotalPrice(customerId,stockId,quantity);

		  return new ResponseEntity<>(latestStockPrice, HttpStatus.OK);
		
	}
	
	  @Bean
	  public RestTemplate restTemplate() { 
		  return new RestTemplate();
	  }
	 
}
