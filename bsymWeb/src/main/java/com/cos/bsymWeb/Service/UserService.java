package com.cos.bsymWeb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.bsymWeb.model.Users;
import com.cos.bsymWeb.repository.UsersRepository;

@Service
public class UserService {
	@Autowired
	private UsersRepository usersRepository;
	
	public Users userCreate(Users user) {
		return usersRepository.save(user);
	}

}
