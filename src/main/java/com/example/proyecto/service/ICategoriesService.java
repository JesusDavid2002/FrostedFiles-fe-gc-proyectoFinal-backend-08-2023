package com.example.proyecto.service;

import java.util.List;

import com.example.proyecto.dto.Categories;

public interface ICategoriesService {

	// Lista todos las categorias
	public List<Categories> listarCategories();
	
	// Muestra la categoria con esa id
	public Categories categoryID(int codigo);
		
	public Categories categoryNombre(String nombre);
	
	// Guarda la categoria
	public Categories guardarCategory(Categories category);

	// Actualiza la categoria
	public Categories actualizarCategory(String nombre, Categories category);
	
	// Elimina la categoria
	public void eliminarCategory(int codigo);
	
	// Elimina la categoria
	public void eliminarCategoryXNombre(String nombre);


}
