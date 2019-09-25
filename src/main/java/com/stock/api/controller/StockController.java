package com.stock.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.stock.api.dto.StockPriceResponseDto;
import com.stock.api.dto.StockResponseDTO;
import com.stock.api.service.StockService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api")
@RestController
@Slf4j
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" }) 

public class StockController {
	
	@Autowired
	StockService stockService;
	
	@GetMapping("/customers/{customerId}/stocks/{stockId}/{quantity}")
	public ResponseEntity<StockPriceResponseDto> getStockPrice(@PathVariable int customerId, @PathVariable int stockId, @PathVariable int quantity) throws IOException 
	{
		StockPriceResponseDto latestStockPrice = stockService.getStockTotalPrice(customerId,stockId,quantity);

		  return new ResponseEntity<>(latestStockPrice, HttpStatus.OK);
		
	}

		@GetMapping("/stocks")
		public ResponseEntity<List<StockResponseDTO>> viewAllStocks() {
			log.info("inside view all stocks method of stock controller");
			List<StockResponseDTO> response = stockService.viewAllStocks();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
		@GetMapping("/stocks/{stockId}")
		public ResponseEntity<StockResponseDTO> getParticualarStock(@PathVariable Integer stockId) {
			log.info("inside view all stocks method of stock controller");
			StockResponseDTO response = stockService.getParticualarStock(stockId);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
		
		  @Bean
		  public RestTemplate restTemplate() { 
			  return new RestTemplate();
		  }
}
