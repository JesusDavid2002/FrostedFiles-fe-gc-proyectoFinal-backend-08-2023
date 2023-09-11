package com.example.proyecto.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.dto.Files;

public interface IFilesDAO  extends JpaRepository<Files, Integer>{
	Files findByNombre(String nombre);
	Files findByExtension(String extension);
			
	void deleteByNombre(String nombre);
}
