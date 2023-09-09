package com.example.proyecto.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.dto.Categories;

public interface ICategoriesDAO  extends JpaRepository<Categories, Integer>{

	Categories getByNombre(String nombre);
	
	void deleteByNombre(String nombre);

	Optional<Categories> findByNombre(String string);

}
