package com.example.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.dto.Users;

public interface IUsersDAO  extends JpaRepository<Users, Integer>{

}
