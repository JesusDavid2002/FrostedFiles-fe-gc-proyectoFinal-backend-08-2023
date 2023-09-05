package com.example.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.dao.IAccionesDAO;
import com.example.proyecto.dto.Acciones;

@Service
public class AccionesServiceImpl implements IAccionesService{
	
	@Autowired
	IAccionesDAO iAccionesDAO;
	
	@Override
	public List<Acciones> listarAcciones() {
		// TODO Auto-generated method stub
		return iAccionesDAO.findAll();
	}

	@Override
	public Acciones accionID(int codigo) {
		// TODO Auto-generated method stub
		return iAccionesDAO.findById(codigo).get();
	}

	@Override
	public Acciones guardarAccion(Acciones acciones) {
		// TODO Auto-generated method stub
		return iAccionesDAO.save(acciones);
	}

	@Override
	public Acciones actualizarAccion(Acciones acciones) {
		// TODO Auto-generated method stub
		return iAccionesDAO.save(acciones);
	}

	@Override
	public void eliminarAccion(int codigo) {
		// TODO Auto-generated method stub
		iAccionesDAO.deleteById(codigo);
	}

}
