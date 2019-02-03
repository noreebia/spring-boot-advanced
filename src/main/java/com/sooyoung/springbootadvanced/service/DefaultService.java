package com.sooyoung.springbootadvanced.service;

import org.springframework.stereotype.Service;

import com.sooyoung.springbootadvanced.exception.CustomException;

@Service
public class DefaultService {
	
	public String throwNormalException() throws Exception {
		throw new Exception("You have fucked up! - from your ordinary exception");
	}
	
	public String throwCustomException() throws CustomException {
		throw new CustomException("You have fucked up! - from your friendly CustomException");
	}
}
