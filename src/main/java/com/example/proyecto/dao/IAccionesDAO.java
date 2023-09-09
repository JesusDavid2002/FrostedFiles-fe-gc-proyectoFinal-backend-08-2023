package com.example.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.dto.Acciones;

public interface IAccionesDAO  extends JpaRepository<Acciones, Integer>{
	
}
