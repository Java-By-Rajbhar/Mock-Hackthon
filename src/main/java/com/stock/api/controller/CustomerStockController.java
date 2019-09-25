package com.stock.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.api.dto.CustomerStockResDto;
import com.stock.api.service.CustomerStockService;
/**
 * 
 * @author Pradeepa AJ
 *
 */

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class CustomerStockController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerStockController.class);
	
	@Autowired
	private CustomerStockService customerStockService ;
	
	/**
	 * 
	 * @param customerId -NotNull
	 * @return CustomerStockResDto-list of purchased stocks of customer
	 */
	
	@GetMapping("/customers/{customerId}/stocks")
	public ResponseEntity<List<CustomerStockResDto>> getPurchasedStocks(@PathVariable Integer customerId){
		logger.info(":: Enter into CustomerStockController--------::getPurchasedStocks()");
		return new ResponseEntity<>(customerStockService.getPurchasedStocks(customerId),HttpStatus.OK);
	}

	

}
