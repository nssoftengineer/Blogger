package com.ns.blogger.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ns.blogger.entities.User;
import com.ns.blogger.exceptions.ResourceNotFound;
import com.ns.blogger.models.UserDto;
import com.ns.blogger.models.UserPagerResponse;
import com.ns.blogger.repo.UserRepo;
import com.ns.blogger.services.UserService;



@Service
public class UserImpl implements UserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.userDtoToUser(userDto);
		userRepo.save(user);
		return this.userToUserDto(user);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer id) {
		
		User user = userRepo.findById(id).orElseThrow(()->new ResourceNotFound("User", "Id", id));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		userRepo.save(user);
		return this.userToUserDto(user);
		
	}

	@Override
	public UserDto getUserById(Integer id) {
		User user = userRepo.findById(id).orElseThrow(()->new ResourceNotFound("User", "Id", id));
		return this.userToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepo.findAll();
		return users.stream().map(user->this.userToUserDto(user)).collect(Collectors.toList());
	}
	
	
	//pagination
	@Override
	public UserPagerResponse getAllUserByPageSize(Integer pageNumber, Integer PageSize) {
		Pageable pageable= PageRequest.of(pageNumber, PageSize);
		Page<User> pages = userRepo.findAll(pageable);
		List<User> listUser = pages.getContent();
		List<UserDto>listDto = listUser.stream().map(user->this.userToUserDto(user)).collect(Collectors.toList());
		
		UserPagerResponse pagerResponse=new UserPagerResponse(listDto, pages.getNumber(), pages.getSize(), pages.getTotalElements(), pages.getTotalPages(), pages.isLast());
		
		return pagerResponse;
	}

	@Override
	public void deleteUser(Integer id) {
		User user = userRepo.findById(id).orElseThrow(()->new ResourceNotFound("User", "Id", id));
		if(user!=null)
		userRepo.deleteById(id);
	}
	
	private User userDtoToUser(UserDto userDto) {
		User user=modelMapper.map(userDto,User.class);
		
//		User user=new User();
//		user.setId(userDto.getId());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
//		user.setName(userDto.getName());
		
		return user;
		
	}
	
	private UserDto userToUserDto(User user) {
		UserDto userDto=modelMapper.map(user, UserDto.class);
		
//		UserDto userDto=new UserDto();
//		userDto.setId(user.getId());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
//		userDto.setName(user.getName());
		
		return userDto;
		
	}



}
