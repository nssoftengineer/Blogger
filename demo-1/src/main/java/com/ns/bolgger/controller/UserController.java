package com.ns.bolgger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ns.blogger.services.UserService;
import com.ns.bolgger.models.UserDto;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserService userService;

	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto createUserDto=userService.createUser(userDto);	
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		
	} 
	
	
}
