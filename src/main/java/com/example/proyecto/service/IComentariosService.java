package com.example.proyecto.service;

import java.util.List;

import com.example.proyecto.dto.Comentarios;
import com.example.proyecto.dto.Users;

public interface IComentariosService {

	// Lista todos los comentarios
	public List<Comentarios> listarComentarios();
	
	// Muestra el comentario con esa id
	public Comentarios comentarioID(int codigo);
	
	// Guarda el comentario
	public Comentarios guardarComentario(Comentarios comentario);

	// Actualiza el comentario
	public Comentarios actualizarComentario(Comentarios comentario);
	
	// Elimina el comentario
	public void eliminarComentario(int codigo);

}
