package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.mapper.CategoryMapper;

@Service
public class CategoryService{
	
	@Autowired
	CategoryMapper categoryMapper;
	
	public void save(Category category) {
		categoryMapper.insertCategory(category);
	}
}
