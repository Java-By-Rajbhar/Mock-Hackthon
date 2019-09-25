package com.stock.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	/**
	 * 
	 * @param customerId-NotNull
	 * @return CustomerStockResDto -list of customer purchased stocks
	 * @exception InvalidUserException
	 */

	@Override
	public List<CustomerStockResDto> getPurchasedStocks(Integer customerId) {
	Optional<List<CustomerStock>> customerStock=customerStockRepository.findByCustomerId(customerId);
	if(customerStock.isPresent()) {
		List<CustomerStock> purchasedList=customerStock.get();
		List<CustomerStockResDto> cusPurchasedList=new ArrayList<>();
		purchasedList.forEach(stocks->{
			CustomerStockResDto customerStockResDto=new CustomerStockResDto(stocks.getStockId(), stocks.getStockName(),
					stocks.getQuantity(), stocks.getTotalPrice(), stocks.getPurchasedDate());
			cusPurchasedList.add(customerStockResDto);
		});
		return cusPurchasedList;
	}else {
		throw new InvalidUserException(StockUtil.INVALID_USER_EXCEPTION);
	}
		
	}

}
