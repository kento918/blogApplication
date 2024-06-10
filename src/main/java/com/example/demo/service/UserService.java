package com.example.demo.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;

@Service
public class UserService{

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	PasswordEncoder ps;

	public void saveUser(UserEntity user) {
		user.setPassword_salt(createSalt());
		user.setPassword(ps.encode(user.getPassword()/*+user.getPassword_salt()*/));
		user.setRoles("user");
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

	private static String createSalt() {
		char[] salt = {'0', '1', '2', '3', '4', '5', '6', '7','8','9','A','B','C','D','E','F'};
		String salts = "";
		Random r = new Random();
		for(int i = 0; i < 16; i++) {
			salts += salt[r.nextInt(15)];
		}
		return salts;
	} 

}
