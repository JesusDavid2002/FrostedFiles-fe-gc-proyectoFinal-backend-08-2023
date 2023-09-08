package com.example.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.dto.Subcategories;

public interface ISubcategoriesDAO extends JpaRepository<Subcategories, Integer> {

	Subcategories getByNombre(String nombre);
	
	void deleteByNombre(String nombre);

}
