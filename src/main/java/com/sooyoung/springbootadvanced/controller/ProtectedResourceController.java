package com.sooyoung.springbootadvanced.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protected")
public class ProtectedResourceController {

	@GetMapping("")
	public String defaultResponse() {
		return "you have visited /protected!";
	}
}
