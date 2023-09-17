package com.example.proyecto.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.dto.Subcategories;

public interface ISubcategoriesDAO extends JpaRepository<Subcategories, Integer> {

	Subcategories getByNombre(String nombre);
	
	void deleteByNombre(String nombre);

	Optional<Subcategories> findByNombre(String nombre);
	
    List<Subcategories> findByCategory_Nombre(String categoryNombre);

}
