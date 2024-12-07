package com.blog.webb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blog.webb.payloads.ApiResp;

@RestControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResp> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		
	 String message = ex.getMessage();
	 ApiResp apiresp = new ApiResp(message,false);
	 
		return new ResponseEntity<ApiResp>(apiresp, HttpStatus.NOT_FOUND);
	}

}
