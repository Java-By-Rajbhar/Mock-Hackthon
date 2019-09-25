package com.stock.api.service;

import com.stock.api.dto.LoginRequestDto;
import com.stock.api.dto.LoginResponseDto;

public interface LoginService {
	
	public LoginResponseDto userLogin(LoginRequestDto loginRequestDto);
}
