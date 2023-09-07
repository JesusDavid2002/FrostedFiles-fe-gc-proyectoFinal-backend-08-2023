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
		return userRepository.findAll();
	}

	@Override
	public Users usuarioEmail(String email) {
		return userRepository.findByUsername(email).get();
	}

	@Override
	public Users actualizarUsuario(Users usuario) {
		return userRepository.save(usuario);
	}

	@Override
	@Transactional
	public void eliminarUsuarioXEmail(String email) {
		userRepository.deleteByUsername(email);
	}
	
}
