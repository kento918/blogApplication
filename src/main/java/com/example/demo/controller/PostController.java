package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.PostEntity;
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
		model.addAttribute("post", new PostEntity());
		model.addAttribute("flug", false);
		return "/registPost";
	}
	
	@PostMapping("/registPost")
	public String createNewPost(@ModelAttribute PostEntity post, Model model) {
		if(!post.isNull()) {
			post.setSlug(createNewSlug(post));
			post.setAuthorId(1);
			postService.savePost(post);
			return "redirect:/";
			
		}else{
			model.addAttribute("flug",true);
			model.addAttribute("post",post);
			return "/registPost";
		}
	}

	@GetMapping("/posts")
	public String showPosts(Model model) {
		model.addAttribute("postList", postService.getAll());
		return "/posts";
	}
	
	private static String createNewSlug(PostEntity post) {
		return "blog." + post.getTitle().hashCode()/* + userService.getNameById(post.getAuthorId())*/;
	}

}
