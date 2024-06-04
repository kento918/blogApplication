package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PostEntity;
import com.example.demo.mapper.PostMapper;

@Service
public class PostService{
	
	@Autowired
	PostMapper postMapper;
	
	public void savePost(PostEntity post) {
		postMapper.insertPost(post);
	}
	
	public List<PostEntity> getAll(){
		return postMapper.selectAll();
		
	}

	public List<PostEntity> getPostById(int id) {
		return postMapper.getPostById(id);
	}
}
