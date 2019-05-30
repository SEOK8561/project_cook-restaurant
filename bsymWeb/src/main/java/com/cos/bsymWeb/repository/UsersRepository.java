package com.cos.bsymWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.bsymWeb.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{
	public Users findByUserName(String UserName);
}
