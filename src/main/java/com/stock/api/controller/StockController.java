package com.stock.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/stocks")
	public ResponseEntity<List<StockResponseDTO>> viewAllStocks() {
		log.info("inside view all stocks method of stock controller");
		List<StockResponseDTO> response = stockService.viewAllStocks();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
