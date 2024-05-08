package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;

@Service
public class UserService{
	
	@Autowired
	UserMapper userMapper;
	
	public void saveUser(User user) {
		userMapper.insertUser(user);
	}

	public List<User> getAll() {
		return userMapper.getAllUser();
	}
}
