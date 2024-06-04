package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.UserEntity;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM user WHERE id = #{id}")
	UserEntity getUserById(int id);
	
	@Insert("INSERT INTO user (name, password, password_salt) VALUES(#{name}, #{password}, #{password_salt})")
	void insertUser(UserEntity user);
	
	@Select("SELECT * FROM user")
	List<UserEntity> getAllUser();
	
	@Select("SELECT name FROM user WHELE id IN #{id}")
	String getNameById(int id);

	@Select("SELECT * FROM user WHERE name = #{username}")
	boolean isGetUserName(String username);
	
	@Select("SELECT * FROM user WHERE name = #{username}")
	UserEntity getUserByName(String username);
	
	@Select("SELECT name FROM user WHELE id IN #{1}")
	UserEntity getGuestData();
}
