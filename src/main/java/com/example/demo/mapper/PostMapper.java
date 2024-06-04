package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.PostEntity;

@Mapper
public interface PostMapper {
	
	@Select("SELECT * FROM post WHERE authorId = #{authorId}")
	List<PostEntity> getPostById(int id);
	
	@Insert("INSERT INTO post(title, body, authorId, categoryId, slug) VALUES (#{title}, #{body}, #{authorId}, #{categoryId}, #{slug})")
	void insertPost(PostEntity post);
	
	@Select("SELECT * FROM post")
	List<PostEntity> selectAll();
}