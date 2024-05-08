package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Post;
import com.example.demo.service.PostService;
import com.example.demo.service.UserService;

@Controller
public class PostController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;
	
	@GetMapping("/registPost")
	public String registPost(Model model) {
		model.addAttribute("post", new Post());
		model.addAttribute("postList", postService.getAll());
		return "/registPost";
	}
	
	@PostMapping("/registPost")
	public String createNewPost(@ModelAttribute Post post, Model model) {
		post.setSlug(createNewSlug(post));
		postService.savePost(post);
		
		return "redirect:/";
	}

	@GetMapping("/posts")
	public String showPosts(Model model) {
		model.addAttribute("postList", postService.getAll());
		return "/posts";
	}
	
	private static String createNewSlug(Post post) {
		return "blog." + post.getTitle() + post.getId();
	}
	
}
