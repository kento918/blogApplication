package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.PostService;

@Controller
public class HomeController {

	
	@Autowired
	PostService postService;
	
	@GetMapping("/top")
	public String top() {
		return "/top";
	}

	@GetMapping("/home")
	public String home(Model model) {
		return "/home";
	}
	
	@GetMapping("/user/home")
	public String userHome() {
		return "/user/home";
	}
	@GetMapping("/admin/home")
	public String adminHome() {
		return "/admin/home";
	}
	

}
