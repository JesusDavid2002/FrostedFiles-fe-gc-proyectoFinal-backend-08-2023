package com.example.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.dao.IDatosEstadisticosDAO;
import com.example.proyecto.dto.DatosEstadisticos;

@Service
public class DatosEstadisticosServiceImpl implements IDatosEstadisticosService{

	@Autowired
	IDatosEstadisticosDAO iDatosEstadisticosDAO;
	
	@Override
	public List<DatosEstadisticos> listarDatos() {
		// TODO Auto-generated method stub
		return iDatosEstadisticosDAO.findAll();
	}

	@Override
	public DatosEstadisticos datosID(int codigo) {
		// TODO Auto-generated method stub
		return iDatosEstadisticosDAO.findById(codigo).get();
	}

	@Override
	public DatosEstadisticos guardarDato(DatosEstadisticos datos) {
		// TODO Auto-generated method stub
		return iDatosEstadisticosDAO.save(datos);
	}

	@Override
	public DatosEstadisticos actualizarDato(DatosEstadisticos datos) {
		// TODO Auto-generated method stub
		return iDatosEstadisticosDAO.save(datos);
	}

	@Override
	public void eliminarDato(int codigo) {
		// TODO Auto-generated method stub
		iDatosEstadisticosDAO.deleteById(codigo);
	}

}
