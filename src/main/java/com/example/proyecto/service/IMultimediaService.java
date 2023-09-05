package com.example.proyecto.service;

import java.util.List;

import com.example.proyecto.dto.Multimedia;

public interface IMultimediaService {

	// Lista todos los archivos multimedias
	public List<Multimedia> listarMultimedia();
	
	// Muestra el archivo multimedia con esa id
	public Multimedia multimediaID(int codigo);
	
	// Guarda el archivo multimedia
	public Multimedia guardarMultimedia(Multimedia multimedia);

	// Actualiza el archivo multimedia
	public Multimedia actualizarMultimedia(Multimedia multimedia);
	
	// Eliminael archivo multimedia
	public void eliminarMultimedia(int codigo);
}
