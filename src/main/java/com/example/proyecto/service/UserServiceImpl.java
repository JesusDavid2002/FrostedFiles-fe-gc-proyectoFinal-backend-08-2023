package com.example.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.dao.UserRepository;
import com.example.proyecto.dto.Users;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Users> listarUsuarios() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Users usuarioEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(email).get();
	}

	@Override
	public Users guardarUsuario(Users usuario) {
		// TODO Auto-generated method stub
		return userRepository.save(usuario);
	}

	@Override
	public Users actualizarUsuario(Users usuario) {
		// TODO Auto-generated method stub
		usuario.setRoles(usuario.getRoles());
		return userRepository.save(usuario);
	}

	@Override
	@Transactional
	public void eliminarUsuarioXEmail(String email) {
		// TODO Auto-generated method stub
		userRepository.deleteByUsername(email);
	}

}
