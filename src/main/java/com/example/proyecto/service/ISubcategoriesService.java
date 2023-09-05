package com.example.proyecto.service;

import java.util.List;

import com.example.proyecto.dto.Subcategories;

public interface ISubcategoriesService {

	// Lista todos las subcategorias
	public List<Subcategories> listarSubcategories();
	
	// Muestra la subcategoria con esa id
	public Subcategories subcategoryID(int codigo);
	
	// Guarda la subcategoria
	public Subcategories guardarSubcategory(Subcategories subcategory);

	// Actualiza el role
	public Subcategories actualizarSubcategory(Subcategories subcategory);
	
	// Elimina la subcategoria
	public void eliminarSubcategory(int codigo);
}