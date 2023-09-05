package com.example.proyecto.service;

import java.util.List;

import com.example.proyecto.dto.Files;

public interface IFilesService {

	// Lista todos los archivos
	public List<Files> listarFiles();
	
	// Muestra el archivo con esa id
	public Files fileID(int codigo);
	
	// Guarda el archivo
	public Files guardarFile(Files file);

	// Actualiza el archivo
	public Files actualizarFile(Files file);
	
	// Elimina el archivo
	public void eliminarFile(int codigo);
}
