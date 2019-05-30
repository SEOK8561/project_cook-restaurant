package com.cos.bsymWeb.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cos.bsymWeb.MyUtil.UtillCommon;
import com.cos.bsymWeb.Service.UserService;
import com.cos.bsymWeb.model.Rocker;
import com.cos.bsymWeb.model.Users;
import com.cos.bsymWeb.repository.RockerRepository;

@Controller
@RequestMapping("/bsym")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	@GetMapping("/auth/login")
	public String authLogin() {
		return "/auth/login";
	}
	
	
	@GetMapping("/auth/join")
	public String authJoin() {
		return "/auth/join";
	}
	
	
	@PostMapping("/auth/joinProcess")
	public String joinProc(Users user) {
		String rawPassword = user.getPassword();
		String encPassword = passwordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		userService.userCreate(user);
		return "/auth/login";
	}
	
	
	@PostMapping("/api/joinProcess")
	public void apiJoinProc(Users user) {
		String rawPassword = user.getPassword();
		String encPassword = passwordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		userService.userCreate(user);
	}
	
	@GetMapping("/web/myPage/{Id}")
	public String webMyPage(@PathVariable int Id, Model model) {
		model.addAttribute("mypage", userService.findIdMypage(Id).get());
		return "mypage";
	}
	

}
