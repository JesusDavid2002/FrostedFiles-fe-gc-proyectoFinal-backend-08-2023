package com.example.proyecto.service;

import java.util.List;

import com.example.proyecto.dto.Roles;

public interface IRolService {

	// Lista todos los rolesI
	public List<Roles> listarRoles();
	
	// Muestra el role con esa id
	public Roles rolID(int codigo);
	
	// Guarda el role
	public Roles guardarRol(Roles roles);

	// Actualiza el role
	public Roles actualizarRol(Roles roles);
	
	// Elimina el role
	public void eliminarRol(int codigo);
	
}
