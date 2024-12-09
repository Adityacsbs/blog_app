package com.blog.webb.exceptions;

import java.util.HashMap;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
     @ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>>handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		
    	 Map<String,String> resp =  new HashMap<>();
    	 
    	 ex.getBindingResult().getAllErrors().forEach((error)-> {
    		String FieldName =  ((FieldError)error).getField();
    		String message = error.getDefaultMessage();
    		resp.put(FieldName, message); 
    	 });
    	 
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST)  ;
	}
     
     
     @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
     public ResponseEntity<ApiResp> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
         // Create a custom message or use the exception message
         String message = "Request method not supported you have to mention the id : " + ex.getMethod();
         ApiResp apiresp = new ApiResp(message, false);
         return new ResponseEntity<ApiResp>(apiresp, HttpStatus.METHOD_NOT_ALLOWED);
     }
	
	
}
