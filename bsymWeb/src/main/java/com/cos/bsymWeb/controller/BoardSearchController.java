package com.cos.bsymWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.bsymWeb.Service.BlogService;
import com.cos.bsymWeb.model.BsymBoard;
//import com.cos.bsymWeb.repository.BsymBoardRepository;

@Controller
@RequestMapping("/blog")
public class BoardSearchController {
	
	@Autowired
	private BlogService blogService;
//	@Autowired
//	private BsymBoardRepository bsymBoardRepository;

	
	//web 8개씩 찾음
	@GetMapping("web/bloglistPage")
	public String webBlogListFind(String broadcastName, @PageableDefault(size = 8) Pageable pageable, Model model) {
		Page<BsymBoard> list = blogService.bloglistPage(broadcastName, pageable);
		model.addAttribute("blogs",list.getContent());
		return "cook_home";
	}
	
	//app 8개씩 찾음
	@GetMapping("app/bloglistPage")
	public @ResponseBody Page<BsymBoard> appBlogListFind(String broadcastName, @PageableDefault(size = 8) Pageable pageable) {
		Page<BsymBoard> list = blogService.bloglistPage(broadcastName, pageable);
		return list;
	}
	
	@GetMapping("web/blogDetail/{id}")
	public String webBlogDetail(@PathVariable int id, Model model) {
		model.addAttribute("blog", blogService.findId(id).get());
		return "board";
	}
	
	//app 8개씩 찾음
	@GetMapping("app/blogPage/{broadcast}")
	public @ResponseBody Page<BsymBoard> appBListFind(@PathVariable String broadcastName, @PageableDefault(size = 8) Pageable pageable) {
		Page<BsymBoard> list = blogService.bloglistPage(broadcastName, pageable);
		return list;
	}	
	
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
