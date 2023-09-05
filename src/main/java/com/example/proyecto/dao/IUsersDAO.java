package com.example.proyecto.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.dto.Users;

public interface IUsersDAO  extends JpaRepository<Users, Integer>{
	
	Optional<Users> findByEmail(String email);
	
	void deleteByEmail(String email);
}
