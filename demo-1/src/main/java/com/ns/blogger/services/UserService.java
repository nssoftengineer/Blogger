package com.ns.blogger.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ns.bolgger.models.UserDto;


@Service
public interface UserService {
	
	UserDto createUser(UserDto userDtoDto);
	UserDto updateUser(UserDto user, Integer id);
	UserDto getUserById(Integer id);
	List<UserDto> getAllUsers();
	void deleteUser(Integer id);

}
