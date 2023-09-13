package com.example.proyecto.service;

import java.util.List;
import java.util.Optional;

import com.example.proyecto.dto.Categories;
import com.example.proyecto.dto.Files;

public interface IFilesService {

	// Lista todos los archivos
	public List<Files> listarFiles();
	
	// Muestra el archivo con esa id
	public Files fileID(int codigo);
	
	// Muestra el archivo con ese nombre
	public Files fileNombre(String nombre);
	
	// Muestra los archivos con esa extension
	public Files fileExtension(String extension);
	
	// Guarda el archivo
	public Files guardarFile(Files file);

	// Actualiza el archivo
	public Files actualizarFile(String nombre, Files file);
	
	// Elimina el archivo
	public void eliminarFile(int codigo);
	
	// Elimina el archivo
	public void eliminarFileByNombre(String nombre);

}
