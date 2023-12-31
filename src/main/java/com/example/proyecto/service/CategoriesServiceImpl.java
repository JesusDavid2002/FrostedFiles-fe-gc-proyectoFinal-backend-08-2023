package com.example.proyecto.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.dao.ICategoriesDAO;
import com.example.proyecto.dto.Categories;
import com.example.proyecto.dto.Files;

@Service
public class CategoriesServiceImpl implements ICategoriesService{

	@Autowired
	ICategoriesDAO iCategoriesDAO;
	
	@Override
	public List<Categories> listarCategories() {
		return iCategoriesDAO.findAll();
	}

	@Override
	public Categories categoryID(int codigo) {
		return iCategoriesDAO.findById(codigo).get();
	}
	
	@Override
	public Categories categoryNombre(String nombre) {
		return iCategoriesDAO.getByNombre(nombre);
	}
		
	@Override
	public Categories guardarCategory(Categories category) {
		return iCategoriesDAO.save(category);
	}
	
	public List<Files> getFilesByCategory(String nombreCategory){
		Categories category = iCategoriesDAO.getByNombre(nombreCategory);
		
		if(category != null) {
			List<Files> files = category.getFiles();
			return files;
		}else {
			return Collections.emptyList();
		}
	}
	
	@Override
	public Categories actualizarCategory(String nombre, Categories category) {
		Categories categoriaSelect = iCategoriesDAO.getByNombre(nombre);

		categoriaSelect.setNombre(category.getNombre());
		return iCategoriesDAO.save(categoriaSelect);
	}

	@Override
	public void eliminarCategory(int codigo) {
		iCategoriesDAO.deleteById(codigo);
	}

	@Override
	public void eliminarCategoryXNombre(String nombre) {
		iCategoriesDAO.deleteByNombre(nombre);
	}

	public void flush() {
		// TODO Auto-generated method stub
		iCategoriesDAO.flush();
	}

	

}
