package com.example.proyecto.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.dao.IAccionesDAO;
import com.example.proyecto.dto.Acciones;
import com.example.proyecto.dto.Files;

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
	
	@Override
	public Map<String, Map<String, Integer>> obtenerEstadisiticasMensuales(List<Acciones> acciones) {
				
		Map<String, Map<String, Integer>> estadisticaMensual = new HashMap<>();
		
		for(Acciones accion : acciones) {
			LocalDateTime fecha = accion.getFecha();
			String mes = obtenerMes(fecha);
			String tipo = accion.getTipoAccion();
			
			estadisticaMensual.putIfAbsent(mes, new HashMap<>());
			Map<String, Integer> estadisiticaTipo = estadisticaMensual.get(mes);
			estadisiticaTipo.put(tipo, estadisiticaTipo.getOrDefault(tipo, 0) + 1);
			
		}
		return estadisticaMensual;
	}
	
	public Map<String, Map<String, Integer>> obtenerEstadisiticasAnuales(List<Acciones> acciones) {
		Map<String, Map<String, Integer>> estadisticaAnuales = new HashMap<>();
		
		for(Acciones accion : acciones) {
			LocalDateTime fecha = accion.getFecha();
			String anyo = obtenerAno(fecha);
			String mes = obtenerMes(fecha);
			String tipo = accion.getTipoAccion();
			
			if(anyo.equals(obtenerAnoActual())) {
				estadisticaAnuales.putIfAbsent(mes, new HashMap<>());
				Map<String, Integer> estadisiticaTipo = estadisticaAnuales.get(mes);
				estadisiticaTipo.put(tipo, estadisiticaTipo.getOrDefault(tipo, 0) + 1);
			}
		}
		return estadisticaAnuales;
	}

	public Acciones guardarAccion(String tipo, LocalDateTime fechaSubida, Files file) {
		Acciones accion = new Acciones(tipo, fechaSubida, file);
		return iAccionesDAO.save(accion);
	}	
	
	private String obtenerMes(LocalDateTime fecha) {
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("MMMM");
		return fecha.format(formatoFecha);
	}

	private String obtenerAno(LocalDateTime fecha) {
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy");
		return fecha.format(formatoFecha);
	}
	
	private Object obtenerAnoActual() {
		LocalDateTime fechaActual = LocalDateTime.now();
		return fechaActual;
	}
}
