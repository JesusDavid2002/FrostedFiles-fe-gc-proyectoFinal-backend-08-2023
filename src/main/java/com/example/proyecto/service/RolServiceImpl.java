package com.example.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.dao.IRolesDAO;
import com.example.proyecto.dto.Roles;

@Service
public class RolServiceImpl implements IRolService{

	@Autowired
	IRolesDAO iRolesDAO;
	
	@Override
	public List<Roles> listarRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Roles rolID(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Roles guardarRol(Roles roles) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Roles actualizarRol(Roles roles) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarRol(int codigo) {
		// TODO Auto-generated method stub
		
	}

}
