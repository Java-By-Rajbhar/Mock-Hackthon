package com.stock.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(StockEmptyException.class)
	public ResponseEntity<ErrorResponse> globalExceptionHandler(StockEmptyException exception, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value(),
				request.getDescription(false));

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(InvalidUserException.class)
	public ResponseEntity<ErrorResponse> invalidUserExceptionHandler(InvalidUserException exception, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value(),
				request.getDescription(false));

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}
	

}
