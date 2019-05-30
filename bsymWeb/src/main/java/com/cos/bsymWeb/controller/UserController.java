package com.cos.bsymWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cos.bsymWeb.Service.UserService;
import com.cos.bsymWeb.model.Users;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/join")
	public String userCreate(Users user) {
		userService.userCreate(user);
		return "index";
	}

}
