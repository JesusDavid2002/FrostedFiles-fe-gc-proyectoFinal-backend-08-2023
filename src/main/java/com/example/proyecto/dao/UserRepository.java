package com.example.proyecto.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.dto.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	Optional<Users> findByUsername(String username);
	
	void deleteByUsername(String username);
}
