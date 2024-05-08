package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM user WHERE id = #{id}")
	User getUserById(int id);
	
	@Insert("INSERT INTO user (name, password, password_salt) VALUES(#{name}, #{password}, #{password_salt})")
	void insertUser(User user);
	
	@Select("SELECT * FROM user")
	List<User> getAllUser();
}
