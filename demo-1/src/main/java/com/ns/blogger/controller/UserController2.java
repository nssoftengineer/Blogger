package com.ns.blogger.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ns.blogger.models.ApiResponse;
import com.ns.blogger.models.UserDto;
import com.ns.blogger.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController2 {
	
	@Autowired
	UserService userService;

	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createUserDto=userService.createUser(userDto);	
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		
	} 
	
	@RequestMapping("/get")
	public String get() {
		
		return "neeraj";
		
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer userId) {
		UserDto createUserDto=userService.updateUser(userDto,userId);	
		return new ResponseEntity<>(createUserDto,HttpStatus.OK);
		
	}
	
//	@DeleteMapping("/{userId}")
//	public ResponseEntity<UserDto> createUser(@PathVariable Integer userId) {
//		userService.deleteUser(userId);	
//		return new ResponseEntity(Map.of("Message","User deleted successfully."),HttpStatus.OK);
//		
//	}
	
	@DeleteMapping("/del/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId) {
		userService.deleteUser(userId);	
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully.",true),HttpStatus.OK);
		
	}
	
	@GetMapping("/get/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable("userId") Integer userId) {
			
		return new ResponseEntity<UserDto>(userService.getUserById(userId),HttpStatus.OK);
		
	}
	
	
}
