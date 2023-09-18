package com.example.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.dao.IComentariosDAO;
import com.example.proyecto.dto.Comentarios;
import com.example.proyecto.dto.Users;

@Service
public class ComentariosServiceImpl implements IComentariosService{

	@Autowired
	IComentariosDAO iComentariosDAO;
	
	
	@Override
	public List<Comentarios> listarComentarios() {
		// TODO Auto-generated method stub
		return iComentariosDAO.findAll();
	}

	@Override
	public Comentarios comentarioID(int codigo) {
		// TODO Auto-generated method stub
		return iComentariosDAO.findById(codigo).get();
	}
	
	@Override
	public Comentarios guardarComentario(Comentarios comentario) {
		// TODO Auto-generated method stub
		return iComentariosDAO.save(comentario);
	}
	
	@Override
	public Comentarios actualizarComentario(Comentarios comentario) {
		// TODO Auto-generated method stub
		return iComentariosDAO.save(comentario);
	}

	@Override
	public void eliminarComentario(int codigo) {
		// TODO Auto-generated method stub
		iComentariosDAO.deleteById(codigo);
	}

	

}
