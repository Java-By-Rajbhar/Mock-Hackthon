package com.stock.api.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.stock.api.dto.LoginRequestDto;
import com.stock.api.dto.LoginResponseDto;
import com.stock.api.entity.Customer;
import com.stock.api.exception.InvalidUserException;
import com.stock.api.repository.CustomerRepository;
import com.stock.api.util.StockUtil;
/**
 * 
 * @author Sushil
 *
 */
@Service
public class LoginServiceImpl implements LoginService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	CustomerRepository customerRepository;
    /**
     * This method is use login with given email id and password
     * @param loginRequestDto,null
     * @return LoginResponseDto
     * @exception InvalidUserException throws if email id and password are not available in database
     */
	@Override
	public LoginResponseDto userLogin(LoginRequestDto loginRequestDto)  {
	
		LOGGER.info("Inside userlogin of LoginServiceImpl ");
		LoginResponseDto responseDto;
		Optional<Customer> customer = customerRepository.findByEmail(loginRequestDto.getEmail());
		if(!customer.isPresent())
		{
			LOGGER.error("exception ={}",StockUtil.INVALID_USER_EXCEPTION);
			throw new  InvalidUserException(StockUtil.INVALID_USER_EXCEPTION);
		}

		if (customer.get().getEmail().equals(loginRequestDto.getEmail())
				&& customer.get().getPassword().equals(loginRequestDto.getPassword())) {
			responseDto = new  LoginResponseDto();
			responseDto.setCustomerId(customer.get().getCustomerId());
			responseDto.setMessage(StockUtil.LOGIN_SUCCESS_MESSAGE);
			responseDto.setStatusCode(HttpStatus.OK.value());
			
		} else {
			LOGGER.error("exception ={}",StockUtil.INVALID_EMAIL_OR_PASSWORD);
			throw new  InvalidUserException(StockUtil.INVALID_EMAIL_OR_PASSWORD);
		}

		return responseDto;
	}

}

