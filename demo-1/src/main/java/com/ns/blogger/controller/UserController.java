package com.ns.blogger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController { 
	
	@RequestMapping("/get")
	public String get() {
		
		return "neeraj";
		
	}
	
	
}
