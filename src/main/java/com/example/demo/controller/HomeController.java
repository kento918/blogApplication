package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@Autowired
	PostService postService;

	@GetMapping("/")
	public String top() {
		log.info("comeing guest!");
		return "/top";
	}

	@GetMapping("/userHome")
	public String userHome() {
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			log.info(auth.getName() + " come home");
			return "/user/home";
		} catch (Exception e) {
			log.error(e.getMessage());
			return "/login";
		}
	}

	@GetMapping("/adminHome")
	public String adminHome() {
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			log.info(auth.getName() + " come home");
			return "/admin/home";
		} catch (Exception e) {
			log.error(e.getMessage());
			return "/login";
		}
	}
}
