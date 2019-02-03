package com.sooyoung.springbootadvanced.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomException extends RuntimeException{

	private static final long serialVersionUID = 1989444365139536016L;

	public CustomException(String message) {
		super(message);
	}
}
