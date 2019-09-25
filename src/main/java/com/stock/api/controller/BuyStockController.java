package com.stock.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.api.dto.CustomerStockRequestDTO;
import com.stock.api.dto.CustomerStockResponseDTO;
import com.stock.api.service.BuyStockService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api")
@RestController
@Slf4j
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class BuyStockController {
	@Autowired
	BuyStockService buyStockService;

	@PostMapping("/stocks/buy")
	public ResponseEntity<CustomerStockResponseDTO> buyStock(
			@RequestBody CustomerStockRequestDTO customerStockRequestDTO) {
		log.info("Inside buyStock method");

		CustomerStockResponseDTO response = buyStockService.buyStock(customerStockRequestDTO);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
