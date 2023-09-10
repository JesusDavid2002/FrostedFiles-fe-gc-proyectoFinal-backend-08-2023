package com.example.proyecto.service;

import java.util.List;

import com.example.proyecto.dto.CompartirFile;

public interface ICompartirFileService {
	
	// Lista todos las acciones
	public List<CompartirFile> listarAcciones();
	
	// Muestra la accion con esa id
	public CompartirFile compartirID(int codigo);
	
	// Guarda la accion
	public CompartirFile guardarCompartir(CompartirFile archivo);

	// Actualiza la accion
	public CompartirFile actualizarCompartir(CompartirFile archivo);
	
	// Elimina la accion
	public void eliminarCompartir(int codigo);
}
