package com.sooyoung.springbootadvanced.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class DefaultController {

	@GetMapping
	public String defaultResponse(HttpServletRequest requestObject) {
		System.out.println(requestObject.getHeaderNames());
		return "hello!";
	}
}
