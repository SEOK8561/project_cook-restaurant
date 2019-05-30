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
import com.cos.bsymWeb.model.Likes;
import com.cos.bsymWeb.repository.BsymBoardRepository;
import com.cos.bsymWeb.repository.LikesRepository;
import com.google.gson.Gson;

@Service
public class BlogService {
	@Autowired
	private BsymBoardRepository bsymBoardRepository;
	@Autowired
	private Gson gson;
	
	
	
	public Page<BsymBoard> bloglistPage(String div, String broadcastName, Pageable pageable){
		System.out.println("검색구분"+div);
		System.out.println("검색방송네임"+broadcastName);
		if(div.equals("cook")&&broadcastName==null){
			broadcastName="스페인하숙";
		}
		else if(div.equals("res")&&broadcastName==null) {
			broadcastName="미식클럽";
		}
		Page<BsymBoard> list = bsymBoardRepository.findByBroadcastName( broadcastName, pageable);
//		List<Likes> like = likesRepository.findByRockerId(2);
		for(int i=0;i<list.getSize();i++) {
			
		}
		
		return list;
	}
	public List<BsymBoard> blogfindAll(String broadcastName) {
		return bsymBoardRepository.findByBroadcastName(broadcastName);
	}



	public Optional<BsymBoard> findId(int id) {
		return bsymBoardRepository.findById(id);
	}
	
	public BsymBoard updata(BsymBoard bsymBoard) {
		bsymBoard.setReadCount(bsymBoard.getReadCount()+1);
		return bsymBoardRepository.save(bsymBoard);
	}



//	public Page<BsymBoard> allPage(@PageableDefault(size = 8) Pageable pageable) {
//		
//		return bsymBoardRepository.findAll(pageable);
//	}
}
