package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;

@Service
public class UserService{

	@Autowired
	UserMapper userMapper;

	public void saveUser(UserEntity user) {
		userMapper.insertUser(user);
	}

	public List<UserEntity> getAll() {
		return userMapper.getAllUser();
	}

	public String getNameById(int id) {
		return userMapper.getNameById(id);
	}

	public boolean isGetUserName(String username) {
		return userMapper.isGetUserName(username);
	}

	public UserEntity getUserByName(String username) {
		return userMapper.getUserByName(username);
	}

	public UserEntity getGuestData() {
		return userMapper.getGuestData();
	}



}
