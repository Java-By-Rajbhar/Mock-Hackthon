package com.stock.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.api.dto.CustomerStockResDto;
import com.stock.api.entity.CustomerStock;
import com.stock.api.exception.InvalidUserException;
import com.stock.api.repository.CustomerStockRepository;
import com.stock.api.util.StockUtil;
/**
 * 
 * @author Pradeep AJ
 *
 */

@Service
public class CustomerStockServiceImpl implements CustomerStockService {
	
	@Autowired
	private CustomerStockRepository customerStockRepository;
	private static final Logger logger = LoggerFactory.getLogger(CustomerStockServiceImpl.class);
	
	/**
	 *  implementation of getting customer purchased stocks
	 * @param customerId-NotNull
	 * @return CustomerStockResDto -list of customer purchased stocks
	 * @exception InvalidUserException
	 */

	@Override
	public List<CustomerStockResDto> getPurchasedStocks(Integer customerId) {
	Optional<List<CustomerStock>> customerStock=customerStockRepository.findByCustomerId(customerId);
	logger.info(":: Enter into getPurchasedStocks()----- ");
	if(customerStock.isPresent()) {
		List<CustomerStock> purchasedList=customerStock.get();
		List<CustomerStockResDto> cusPurchasedList=new ArrayList<>();
		purchasedList.forEach(stocks->{
			logger.info(":: valid customer purchase history-----::={}",stocks.getStockName());
			CustomerStockResDto customerStockResDto=new CustomerStockResDto(stocks.getStockId(), stocks.getStockName(),
					stocks.getQuantity(), stocks.getTotalPrice(), stocks.getPurchasedDate());
			cusPurchasedList.add(customerStockResDto);
		});
		return cusPurchasedList;
	}else {
		throw new InvalidUserException(StockUtil.INVALID_CUSTOMER_EXCEPTION);
	}
		
	}

}
