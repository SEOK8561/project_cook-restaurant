package com.cos.bsymWeb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cos.bsymWeb.Service.BlogService;
import com.cos.bsymWeb.Service.CustomUserDetails;
import com.cos.bsymWeb.model.BsymBoard;
import com.google.gson.Gson;
//import com.cos.bsymWeb.repository.BsymBoardRepository;

@Controller
@RequestMapping("/bsym")
public class BoardSearchController {
	
	@Autowired
	private BlogService blogService;
	@Autowired
	private Gson gson;
	@Autowired
	private HttpSession session;
	 

	@GetMapping("/web/home")
	public String Home() {
		return "home";
	}
	
	//web 다뿌림
	@GetMapping("/web/bloglistAll/{div}")
	public String webBlogFindAll(@PathVariable String div, String broadcastName, Model model) {
		List<BsymBoard> list = blogService.blogfindAll(broadcastName);
		model.addAttribute("blogs",list);
		model.addAttribute("castName",broadcastName);
		session.setAttribute("blogInfo", list.get(0));
		//model.addAttribute("user",userDetail.getUser());
		if(div.equals("cook")) {
			return "cook_home";
		}else if(div.equals("res")) {
			return "res_home";
		}
		return null;
	}
	
	//web 8개씩 찾음
	@GetMapping("/web/bloglistPage/{div}")
	public String webBlogListFind(@PathVariable String div, String broadcastName, @PageableDefault(size = 8) Pageable pageable, Model model) {
		Page<BsymBoard> list = blogService.bloglistPage(div, broadcastName, pageable);
		model.addAttribute("blogs",list.getContent());
		model.addAttribute("castName",broadcastName);
		session.setAttribute("blogInfo", list.getContent().get(0));
		if(div.equals("cook")) {
			return "cook_home";
		}else if(div.equals("res")) {
			return "res_home";
		}
		return null;
	}
	
	//ajax용 8 페이지
	@PostMapping("/web/listSearch/{div}")
	public @ResponseBody List<BsymBoard> webBlogListsearch(@PathVariable String div, @RequestBody String broadcastName, @PageableDefault(size = 8) Pageable pageable) {
		System.out.println("첫번째 검색대상"+broadcastName);
		BsymBoard bsymboard = gson.fromJson(broadcastName, BsymBoard.class);
		System.out.println("뽑은 검색대상"+bsymboard.getBroadcastName());
		Page<BsymBoard> list = blogService.bloglistPage(div, bsymboard.getBroadcastName(), pageable);
		System.out.println(broadcastName+"검색 데이터값 : "+list.getContent());
		session.setAttribute("blogInfo", list.getContent().get(0));
		return list.getContent();
	}
	
	//app 다뿌림
	@GetMapping("/app/bloglistAll/{div}")
	public @ResponseBody List<BsymBoard> appBlogFindAll(@PathVariable String div, String broadcastName) {
		List<BsymBoard> list = blogService.blogfindAll(broadcastName);
		return list;
	}
	
	//app 8개씩 찾음
	@GetMapping("/app/bloglistPage/{div}")
	public @ResponseBody List<BsymBoard> appBlogListFind(@PathVariable String div, String broadcastName, @PageableDefault(size = 8) Pageable pageable) {
		Page<BsymBoard> list = blogService.bloglistPage(div, broadcastName, pageable);
		return list.getContent();
	}
	
	@GetMapping("/web/blogDetail/{id}")
	public String webBlogDetail(@PathVariable int id, Model model) {
		BsymBoard bsymboard = blogService.updata(blogService.findId(id).get());
		model.addAttribute("blog", bsymboard);
		return "detail";
	}
	
//	@GetMapping("/redirect")
//	public String redirectPage(HttpServletRequest request) {
//		return "redirect
//	}
	
	//app 8개씩 찾음
//	@GetMapping("app/blogPage/{broadcast}")
//	public @ResponseBody Page<BsymBoard> appBListFind(@PathVariable String broadcastName, @PageableDefault(size = 8) Pageable pageable) {
//		Page<BsymBoard> list = blogService.bloglistPage(broadcastName, pageable);
//		return list;
//	}
	
	
//	//app 8개씩 찾음
//	@GetMapping("app/bloglistPage/{pageable}")
//	public @ResponseBody Page<BsymBoard> apptestFind(@PathVariable @PageableDefault(size = 8) Pageable pageable) {
//		Page<BsymBoard> list = blogService.bloglistPage("수미네반찬", pageable);
//		return list;
//	}

	
//	//테스트용
//	@GetMapping("web/all")
//	public String all(Model model) {
//		model.addAttribute("blogs",bsymBoardRepository.findAll());
//		return "index";
//	}
	
}
