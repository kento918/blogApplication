package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Post;
import com.example.demo.mapper.PostMapper;

@Service
public class PostService{
	
	@Autowired
	PostMapper postMapper;
	
	public void savePost(Post post) {
		postMapper.insertPost(post);
	}
	
	public List<Post> getAll(){
		return postMapper.selectAll();
		
	}

	public List<Post> getPostById(int id) {
		return postMapper.getPostById(id);
	}
}
