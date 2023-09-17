package com.example.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.dao.IRolesDAO;
import com.example.proyecto.dto.Roles;

@Service
public class RolesServiceImpl implements IRolesService{

	private final IRolesDAO iRolesDAO;

    	@Autowired
    	public RolesServiceImpl(IRolesDAO iRolesDAO) {
        	this.iRolesDAO = iRolesDAO;
    	}

	@Override
	public Roles rolNombre(String nombre) {
		// TODO Auto-generated method stub
		return iRolesDAO.findByNombre(nombre);
	}

	@Override
	public Roles guardarRol(Roles rol) {
		// TODO Auto-generated method stub
		return iRolesDAO.save(rol);
	}

	@Override
	public Roles actualizarRol(Roles rol) {
		// TODO Auto-generated method stub
		return iRolesDAO.save(rol);
	}

	@Override
	public void eliminarRolXNombre(String nombre) {
		// TODO Auto-generated method stub
		iRolesDAO.deleteByNombre(nombre);
	}

}
