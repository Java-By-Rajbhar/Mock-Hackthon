package com.stock.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.api.dto.LoginRequestDto;
import com.stock.api.dto.LoginResponseDto;
import com.stock.api.service.LoginService;

@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	/**
	 * This method is use to login 
	 * @param loginRequestDto, not null
	 * @return LoginResponseDto
	 */
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> userLogin(@RequestBody LoginRequestDto loginRequestDto){
		LOGGER.info("Inside userLogin of login controller");
		return new ResponseEntity<>(loginService.userLogin(loginRequestDto),HttpStatus.OK);
	}

}
