package com.example.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.dao.ISubcategoriesDAO;
import com.example.proyecto.dto.Subcategories;

@Service
public class SubcategoriesServiceImpl implements ISubcategoriesService{

	@Autowired
	ISubcategoriesDAO iSubcategoriesDAO;
	
	@Override
	public List<Subcategories> listarSubcategories() {
		return iSubcategoriesDAO.findAll();
	}

	@Override
    public List<Subcategories> findByCategory_Nombre(String nombre) {
        return iSubcategoriesDAO.findByCategory_Nombre(nombre);
    }
	
	@Override
	public Subcategories subcategoryNombre(String nombre) {
		return iSubcategoriesDAO.getByNombre(nombre);
	}
	@Override
	public Subcategories guardarSubcategory(Subcategories subcategory) {
		return iSubcategoriesDAO.save(subcategory);
	}

	@Override
	public Subcategories actualizarSubcategory(String nombre, Subcategories subcategory) {
		Subcategories subcategorySelect = iSubcategoriesDAO.getByNombre(nombre);
		
		subcategorySelect.setNombre(subcategory.getNombre());
		return iSubcategoriesDAO.save(subcategorySelect);
	}

	@Override
	public void eliminarSubcategory(int codigo) {
		iSubcategoriesDAO.deleteById(codigo);
	}

	@Override
	public void eliminarSubcategoryXNombre(String nombre) {
		iSubcategoriesDAO.deleteByNombre(nombre);
	}

	@Override
	public Subcategories subcategoryID(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
