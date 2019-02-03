package com.sooyoung.springbootadvanced.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sooyoung.springbootadvanced.pojo.ErrorResponse;

@RestControllerAdvice
public class ExceptionAdvice {

//	@ExceptionHandler(CustomException.class)
//	@ResponseStatus(HttpStatus.BAD_GATEWAY)
//	public ResponseEntity<ErrorResponse> sendErrorResponse(RuntimeException exception) {
//		ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND, "Something bad happened!");
//		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//	}
	
	@ExceptionHandler(CustomException.class)
	@ResponseStatus(HttpStatus.BAD_GATEWAY)
	public ErrorResponse sendErrorResponse(RuntimeException exception) {
		return new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> sendErrorResponse(Exception exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
}
