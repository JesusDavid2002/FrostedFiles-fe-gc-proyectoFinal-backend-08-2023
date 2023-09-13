package com.example.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.dao.IFilesDAO;
import com.example.proyecto.dto.Categories;
import com.example.proyecto.dto.Files;

@Service
public class FilesServiceImpl implements IFilesService{

	@Autowired
	IFilesDAO iFilesDAO;
	
	@Override
	public List<Files> listarFiles() {
		return iFilesDAO.findAll();
	}

	@Override
	public Files fileID(int codigo) {
		return iFilesDAO.findById(codigo).get();
	}
	@Override
	public Files fileNombre(String nombre) {
		return iFilesDAO.findByNombre(nombre);
	}

	@Override
	public Files fileExtension(String extension) {
		return iFilesDAO.findByExtension(extension);
	}
	
	@Override
	public Files guardarFile(Files file) {
		return iFilesDAO.save(file);
	}

	@Override
	public Files actualizarFile(String nombre, Files file) {
		Files fileSelect = iFilesDAO.findByNombre(nombre);
		
		fileSelect.setNombre(file.getNombre());
		fileSelect.setVisibilidad(file.isVisibilidad());
		
		return iFilesDAO.save(fileSelect);
	}

	@Override
	public void eliminarFile(int codigo) {
		iFilesDAO.deleteById(codigo);
	}

	@Override
	public void eliminarFileByNombre(String nombre) {
		iFilesDAO.deleteByNombre(nombre);
	}
	

}
