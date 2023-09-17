package com.example.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.dto.Roles;

public interface IRolesDAO extends JpaRepository<Roles, String>{
	Roles findByNombre(String nombre);
	
	void deleteByNombre(String nombre);
}
