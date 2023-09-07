package com.example.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.proyecto.dao.IRolesDAO;
import com.example.proyecto.dto.Roles;
import com.example.proyecto.dto.RolesEnum;

import jakarta.annotation.PostConstruct;

@Component
@Service
public class RolesServiceImpl {

	@Autowired
	private IRolesDAO iRolesDAO;
	
	@PostConstruct
	public void initRoles() {
		for(RolesEnum role : RolesEnum.values()) {
			Roles rolesExistentes = iRolesDAO.findByNombre(role.name());
			if(rolesExistentes == null) {
				Roles newRol = new Roles();
				newRol.setNombre(role.name());
				iRolesDAO.save(newRol);
			}
		}
	}
}
