package com.ns.blogger.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ns.blogger.models.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFound resourceNotFound){
		String message =  resourceNotFound.getMessage();
		ApiResponse apiResponse =  new ApiResponse(message, false);
		
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> mathodArgumentNotValidException(MethodArgumentNotValidException resourceNotFound){
		Map<String,String> res = new HashMap<>();
		resourceNotFound.getBindingResult().getAllErrors().forEach((error->{
		String filedName=((FieldError) error).getField();
		String message=error.getDefaultMessage();
		res.put(filedName,message);
		}));
		
		return new ResponseEntity<Map<String,String>>(res,HttpStatus.NOT_FOUND);
		
	}
	
	
	
}
