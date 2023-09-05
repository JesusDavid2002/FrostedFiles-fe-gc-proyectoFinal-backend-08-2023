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
		// TODO Auto-generated method stub
		return iSubcategoriesDAO.findAll();
	}

	@Override
	public Subcategories subcategoryID(int codigo) {
		// TODO Auto-generated method stub
		return iSubcategoriesDAO.findById(codigo).get();
	}

	@Override
	public Subcategories guardarSubcategory(Subcategories subcategory) {
		// TODO Auto-generated method stub
		return iSubcategoriesDAO.save(subcategory);
	}

	@Override
	public Subcategories actualizarSubcategory(Subcategories subcategory) {
		// TODO Auto-generated method stub
		return iSubcategoriesDAO.save(subcategory);
	}

	@Override
	public void eliminarSubcategory(int codigo) {
		// TODO Auto-generated method stub
		iSubcategoriesDAO.deleteById(codigo);
	}

}
