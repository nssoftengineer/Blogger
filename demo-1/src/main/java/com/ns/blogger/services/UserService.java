package com.ns.blogger.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ns.blogger.models.UserDto;
import com.ns.blogger.models.UserPagerResponse;





@Service
public interface UserService {
	
	UserDto createUser(UserDto userDtoDto);
	UserDto updateUser(UserDto user, Integer id);
	UserDto getUserById(Integer id);
	List<UserDto> getAllUsers();
	UserPagerResponse getAllUserByPageSize(Integer pageNumber, Integer PageSize);
	UserPagerResponse getAllUserByPageSizeSort(Integer pageNumber, Integer PageSize,String sortBy,String groupBy);
	void deleteUser(Integer id);

}
