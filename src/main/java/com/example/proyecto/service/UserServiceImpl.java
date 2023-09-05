package com.example.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.dao.IUsersDAO;
import com.example.proyecto.dto.Users;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	IUsersDAO iUsersDAO;
	
	@Override
	public List<Users> listarUsuarios() {
		// TODO Auto-generated method stub
		return iUsersDAO.findAll();
	}

	@Override
	public Users usuarioEmail(String email) {
		// TODO Auto-generated method stub
		return iUsersDAO.findByEmail(email).get();
	}

	@Override
	public Users guardarUsuario(Users usuario) {
		// TODO Auto-generated method stub
		return iUsersDAO.save(usuario);
	}

	@Override
	public Users actualizarUsuario(Users usuario) {
		// TODO Auto-generated method stub
		return iUsersDAO.save(usuario);
	}

	@Override
	public void eliminarUsuarioXEmail(String email) {
		// TODO Auto-generated method stub
		iUsersDAO.deleteByEmail(email);
	}

}
