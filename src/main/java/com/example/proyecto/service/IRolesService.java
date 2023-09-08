package com.example.proyecto.service;

import java.util.List;

import com.example.proyecto.dto.Roles;

public interface IRolesService {

	// Lista todos los roles
	public List<Roles> listarRoles();
	
	// Muestra el rol con ese nombre
	public Roles rolNombre(String nombre);
	
	// Guarda la subcategoria
	public Roles guardarRol(Roles rol);

	// Actualiza el rol
	public Roles actualizarRol(Roles rol);

	// Elimina el rol mediante el nombre
	public void eliminarRolXNombre(String nombre);
}
