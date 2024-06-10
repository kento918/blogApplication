package com.example.demo.controller;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.PostEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.PostService;
import com.example.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PostController {

	@Autowired
	UserService userService;

	@Autowired
	PostService postService;

	@GetMapping("/registPost")
	public String registPost(Model model) {
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			model.addAttribute("post", new PostEntity());
			model.addAttribute("flug", false);
			log.info("create new post " + auth.getName());
			return "/post/registPost";
		} catch (Exception e) {
			log.error(e.getMessage());
			return "/login";
		}
	}

	@PostMapping("/registPost")
	public String createNewPost(@ModelAttribute PostEntity post, Model model) {
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserEntity user = userService.getUserByName(auth.getName());
			post.setAuthorId(user.getId());
			postService.savePost(post);
			log.info("save post " + auth.getName() + " succsess");
			return "/" + user.getRoles() + "/home";
		} catch (Exception e) {
			log.error(e.getMessage());
			return "/login";
		}
	}

	@GetMapping("/posts")
	public String showPosts(Model model) throws AccountNotFoundException {
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserEntity currentUser = userService.getUserByName(auth.getName());
			model.addAttribute("postList", postService.getPostByAuthorId(currentUser.getId()));
			model.addAttribute("user", currentUser);
			return "/post/posts";
		} catch (Exception e) {
			log.error(e.getMessage());
			return "/login";
		}
	}
}
