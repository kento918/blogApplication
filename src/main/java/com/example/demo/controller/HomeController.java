package com.example.demo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.service.PostService;
import com.example.demo.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("newUser", new User());
		List<User> li =userService.getAll();
		model.addAttribute("userList", li);
		return "/home";
	}
	
	@PostMapping("/regist")
	public String registerUser(@ModelAttribute User user, Model model) {
		user.setPassword_salt(createSalt().getBytes());
		userService.saveUser(user);
		return "redirect:/";
	}
	
	private static String createSalt() {
		char[] salt = {'0', '1', '2', '3', '4', '5', '6', '7','8','9','A','B','C','D','E','F'};
		String salts = "";
		Random r = new Random();
		for(int i = 0; i < 3; i++) {
			salts += salt[r.nextInt(15)];
		}
		return salts;
	}

}
