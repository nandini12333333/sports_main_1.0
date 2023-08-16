package com.falconSports.exception;

public class IdNotFoundException extends RuntimeException {
	
	private String message;

	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	public IdNotFoundException()
	{
		
	}

}
