package com.reports.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reports.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	
	Users findByUsername(String username);

}
