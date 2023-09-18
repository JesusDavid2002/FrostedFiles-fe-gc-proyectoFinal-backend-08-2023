package com.example.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.dto.Users;

public interface IUserDAO extends JpaRepository<Users, Integer>{
	Users findByUsername(String username);
}
