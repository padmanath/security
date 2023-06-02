package com.alibou.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/testWithoutToken")
@RestController
public class ControllerWithoutAccessToken {

	@GetMapping
	public String get() {
		
		return "Hello from opean url endpoint";
		
	}
	
	
}
