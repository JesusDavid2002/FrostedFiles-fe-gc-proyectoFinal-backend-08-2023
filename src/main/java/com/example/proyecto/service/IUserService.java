package com.example.proyecto.service;

import java.util.List;

import com.example.proyecto.dto.Users;

public interface IUserService {

	// Lista todos los usuarios
	public List<Users> listarUsuarios();
	
	// Muestra el usuario con ese correo
	public Users usuarioEmail(String codigo);
	
	// Guarda el usuario
	public Users guardarUsuario(Users usuario);

	// Actualiza el usuario
	public Users actualizarUsuario(Users usuario);
	
	// Elimina al usuario
	public void eliminarUsuarioXEmail(String email);
	
}
