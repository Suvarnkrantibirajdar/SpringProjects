package com.spring.ExceptionHandler;

import java.util.Map;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice  // it provide the exception handle or exception handler
public class AppExceptionHandler {
	
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)  //display the status on browser or postman
	@ExceptionHandler(MethodArgumentNotValidException.class)  // handle the exception 
	public Map<String,String> handelInvalidArguments(MethodArgumentNotValidException ex)
	{
		Map<String,String> m=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			
			m.put(error.getField(), error.getDefaultMessage());
		});
		return m;
	}
	
	// its handle the Exception
	@ExceptionHandler(UserException.class)
	public Map<String,String> invalidUser(UserException ux)
	{
		Map<String,String> m=new HashMap<>();
		m.put("Error Message", ux.getMessage());
		return m;
	}
}
