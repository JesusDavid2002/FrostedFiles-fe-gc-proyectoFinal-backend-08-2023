package com.example.proyecto.service;

import java.util.List;
import java.util.Map;

import com.example.proyecto.dto.Acciones;

public interface IAccionesService {

	// Lista todos las acciones
	public List<Acciones> listarAcciones();
	
	// Muestra la accion con esa id
	public Acciones accionID(int codigo);
	
	// Guarda la accion
	public Acciones guardarAccion(Acciones acciones);

	// Actualiza la accion
	public Acciones actualizarAccion(Acciones acciones);
	
	// Elimina la accion
	public void eliminarAccion(int codigo);
	
	public Map<String, Map<String, Integer>> obtenerEstadisiticasMensuales(List<Acciones> acciones);
}
