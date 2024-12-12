package com.reports.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<String>  userAlreadyExistsExceptionHandler(UserAlreadyExistsException ex){
		return new ResponseEntity<>("custom exception"+ex.getMessage(), HttpStatus.CONFLICT);
	}

}
