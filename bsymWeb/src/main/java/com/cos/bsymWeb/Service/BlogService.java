package com.cos.bsymWeb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.bsymWeb.model.BsymBoard;
import com.cos.bsymWeb.repository.BsymBoardRepository;
import com.google.gson.Gson;

@Service
public class BlogService {
	@Autowired
	private BsymBoardRepository bsymBoardRepository;
	@Autowired
	private Gson gson;
	
	
	
	public Page<BsymBoard> bloglistPage(String broadcastName, Pageable pageable){
		return bsymBoardRepository.findByBroadcastName( broadcastName, pageable);
	}



	public Optional<BsymBoard> findId(int id) {
		return bsymBoardRepository.findById(id);
	}


//	public Page<BsymBoard> allPage(@PageableDefault(size = 8) Pageable pageable) {
//		
//		return bsymBoardRepository.findAll(pageable);
//	}
}
