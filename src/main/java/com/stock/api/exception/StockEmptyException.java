package com.stock.api.exception;

public class StockEmptyException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StockEmptyException(String message)
	
	{
		super(message);
	}
}
