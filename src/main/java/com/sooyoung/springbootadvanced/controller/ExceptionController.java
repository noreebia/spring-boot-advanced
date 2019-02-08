package com.sooyoung.springbootadvanced.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sooyoung.springbootadvanced.service.DefaultService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value="/exception")
@AllArgsConstructor
public class ExceptionController {
	
	DefaultService defaultService;
	
	@GetMapping("/normal")
	public String aMethod() throws Exception {
		return defaultService.throwNormalException();
	}
	
	@GetMapping("/custom")
	public String anotherMethod() throws Exception {
		return defaultService.throwCustomException();
	}
}
