package com.stock.api.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LoginResponseDto {

	private String message;
	private int statusCode;
	private int customerId;

}