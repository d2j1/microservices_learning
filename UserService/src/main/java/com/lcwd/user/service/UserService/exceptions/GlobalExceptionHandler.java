package com.lcwd.user.service.UserService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lcwd.user.service.UserService.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler( ResourceNotFound.class)
	public ResponseEntity<ApiResponse> handlerRessourceNotFoundException(ResourceNotFound exception) {
		
		String message = exception.getMessage();
		
		ApiResponse response = ApiResponse.builder().msg(message).success(true).httpStatus(HttpStatus.NOT_FOUND).build();
		
		
		return new ResponseEntity<ApiResponse>( response, HttpStatus.NOT_FOUND);
	
	}
	
	
}
