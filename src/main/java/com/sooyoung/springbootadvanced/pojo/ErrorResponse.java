package com.sooyoung.springbootadvanced.pojo;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponse {

	private HttpStatus status;
	private String code;
	private LocalDateTime timestamp;
	private String errorMessage;
	
	private ErrorResponse() {
		this.timestamp = LocalDateTime.now();
	}
	
	public ErrorResponse(HttpStatus status, String errorMessage){
		this();
		this.status = status;
		this.code = this.status.toString();
		this.errorMessage = errorMessage;
	}
	
}
