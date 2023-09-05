package com.example.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.dao.IFilesDAO;
import com.example.proyecto.dto.Files;

@Service
public class FilesServiceImpl implements IFilesService{

	@Autowired
	IFilesDAO iFilesDAO;
	
	@Override
	public List<Files> listarFiles() {
		// TODO Auto-generated method stub
		return iFilesDAO.findAll();
	}

	@Override
	public Files fileID(int codigo) {
		// TODO Auto-generated method stub
		return iFilesDAO.findById(codigo).get();
	}

	@Override
	public Files guardarFile(Files file) {
		// TODO Auto-generated method stub
		return iFilesDAO.save(file);
	}

	@Override
	public Files actualizarFile(Files file) {
		// TODO Auto-generated method stub
		return iFilesDAO.save(file);
	}

	@Override
	public void eliminarFile(int codigo) {
		// TODO Auto-generated method stub
		iFilesDAO.deleteById(codigo);
	}

}
