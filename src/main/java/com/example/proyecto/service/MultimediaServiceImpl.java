package com.example.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.dao.IMultimediaDAO;
import com.example.proyecto.dto.Multimedia;

@Service
public class MultimediaServiceImpl implements IMultimediaService{

	@Autowired
	IMultimediaDAO iMultimediaDAO;
	
	@Override
	public List<Multimedia> listarMultimedia() {
		// TODO Auto-generated method stub
		return iMultimediaDAO.findAll();
	}

	@Override
	public Multimedia multimediaID(int codigo) {
		// TODO Auto-generated method stub
		return iMultimediaDAO.findById(codigo).get();
	}

	@Override
	public Multimedia guardarMultimedia(Multimedia multimedia) {
		// TODO Auto-generated method stub
		return iMultimediaDAO.save(multimedia);
	}

	@Override
	public Multimedia actualizarMultimedia(Multimedia multimedia) {
		// TODO Auto-generated method stub
		return iMultimediaDAO.save(multimedia);
	}

	@Override
	public void eliminarMultimedia(int codigo) {
		// TODO Auto-generated method stub
		iMultimediaDAO.deleteById(codigo);
	}

}
