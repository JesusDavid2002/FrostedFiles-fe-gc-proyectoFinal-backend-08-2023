package com.example.proyecto.service;

import java.util.List;

import com.example.proyecto.dto.DatosEstadisticos;

public interface IDatosEstadisticosService {

	// Lista todos los datos
	public List<DatosEstadisticos> listarDatos();
	
	// Muestra el dato con esa id
	public DatosEstadisticos datosID(int codigo);
	
	// Guarda el dato
	public DatosEstadisticos guardarDato(DatosEstadisticos datos);

	// Actualiza el dato
	public DatosEstadisticos actualizarDato(DatosEstadisticos datos);
	
	// Elimina el dato
	public void eliminarDato(int codigo);
}
