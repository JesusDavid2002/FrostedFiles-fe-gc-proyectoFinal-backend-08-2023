package com.example.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.dao.ICategoriesDAO;
import com.example.proyecto.dto.Categories;

@Service
public class CategoriesServiceImpl implements ICategoriesService{

	@Autowired
	ICategoriesDAO iCategoriesDAO;
	
	@Override
	public List<Categories> listarCategories() {
		// TODO Auto-generated method stub
		return iCategoriesDAO.findAll();
	}

	@Override
	public Categories categoryID(int codigo) {
		// TODO Auto-generated method stub
		return iCategoriesDAO.findById(codigo).get();
	}

	@Override
	public Categories guardarCategory(Categories category) {
		// TODO Auto-generated method stub
		return iCategoriesDAO.save(category);
	}

	@Override
	public Categories actualizarCategory(Categories category) {
		// TODO Auto-generated method stub
		return iCategoriesDAO.save(category);
	}

	@Override
	public void eliminarCategory(int codigo) {
		// TODO Auto-generated method stub
		iCategoriesDAO.deleteById(codigo);
	}

}
