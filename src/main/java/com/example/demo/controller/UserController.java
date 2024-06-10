package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/registUser")
	public String createNewUser(Model model) {
		model.addAttribute("newUser", new UserEntity());
		return "/registUser";
	}

	@PostMapping("/registUser")
	public String registerUser(@ModelAttribute UserEntity user, Model model) {
		userService.saveUser(user);
		return "redirect:/login";
	}

}
