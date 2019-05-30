package com.cos.bsymWeb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.bsymWeb.Service.CustomUserDetails;
import com.cos.bsymWeb.Service.LikeService;
import com.cos.bsymWeb.model.BsymBoard;
import com.cos.bsymWeb.model.Likes;
import com.cos.bsymWeb.model.Rocker;
import com.cos.bsymWeb.model.Users;
import com.cos.bsymWeb.repository.BsymBoardRepository;
import com.cos.bsymWeb.repository.LikesRepository;
import com.cos.bsymWeb.repository.RockerRepository;
import com.google.gson.Gson;

@Controller
@RequestMapping("/bsym")
public class LikeController {
	@Autowired
	private RockerRepository rockerRepository;
	@Autowired
	private LikesRepository likesRepository;
	@Autowired
	private BsymBoardRepository bsymBoardRepository;
	@Autowired
	private Gson gson;
	
	//ajax용 8 페이지
	@PostMapping("/like/{id}")
	public @ResponseBody String like(@PathVariable String id, @AuthenticationPrincipal CustomUserDetails userDetail) {
		Users user = userDetail.getUser();
		System.out.println("유저"+user);
		if(user==null) {
			return "error";
		}else {
			Rocker rocker = rockerRepository.findById(user.getId()).get();
			BsymBoard bsymBoard = bsymBoardRepository.findById(Integer.parseInt(id)).get();
			System.out.println("아이디"+id);
			System.out.println("해당게시물"+bsymBoard);
			Likes like = Likes.builder()
					.bsymBoard(bsymBoard)
					.rocker(rocker)
					.build();	
			likesRepository.save(like);
			return "ok";
		}
	}
	
	@PostMapping("/unlike/{id}")
	public @ResponseBody String unlike(@PathVariable String id, @AuthenticationPrincipal CustomUserDetails userDetail) {
		Users user = userDetail.getUser();
		System.out.println("유저"+user);
		if(user==null) {
			return "error";
		}else {
			Rocker rocker = rockerRepository.findById(user.getId()).get();
			BsymBoard bsymBoard = bsymBoardRepository.findById(Integer.parseInt(id)).get();	
			System.out.println("아이디"+id);
			System.out.println("해당게시물"+bsymBoard);
			likesRepository.deleteLike(rocker.getId(),bsymBoard.getId());
			return "ok";
		}
	}
	

}
