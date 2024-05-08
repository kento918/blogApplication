package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.Category;
import com.example.demo.entity.User;

@Mapper
public interface CategoryMapper {
	@Select("SELECT * FROM category WHERE id = #{id}")
	User getCategoryById(int id);
	
	@Insert("INSERT INTO category (name, description, parentId, order) VALUES(#{name}, #{description}, #{parent_id}, #{order}")
	void insertCategory(Category category);
}
