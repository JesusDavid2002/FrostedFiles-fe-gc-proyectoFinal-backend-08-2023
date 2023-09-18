package com.example.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.dao.IRolesDAO;
import com.example.proyecto.dto.Roles;

@Service
public class RolesServiceImpl implements IRolesService{
	
	@Autowired
	private IRolesDAO iRolesDAO; 
	
	@Override
	public List<Roles> listarRoles() {
		return iRolesDAO.findAll();
	}

	@Override
	public Roles rolNombre(String nombre) {
		return iRolesDAO.findByNombre(nombre);
	}

	@Override
	public Roles guardarRol(Roles rol) {
		return iRolesDAO.save(rol);
	}

	@Override
	public Roles actualizarRol(Roles rol) {
		return iRolesDAO.save(rol);
	}

	@Override
	public void eliminarRolXNombre(String nombre) {
		iRolesDAO.deleteByNombre(nombre);
	}

}
