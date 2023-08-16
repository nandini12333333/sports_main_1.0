package com.falconSports.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainExceptionClass {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handler(ResourceNotFoundException resourceNotFoundException)
	{
		return new ResponseEntity<String>("Data does Not Exist", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> handler(IdNotFoundException idNotFoundException)
	{
		return new ResponseEntity<String>("Id is not Exist", HttpStatus.BAD_REQUEST);
	}

}
