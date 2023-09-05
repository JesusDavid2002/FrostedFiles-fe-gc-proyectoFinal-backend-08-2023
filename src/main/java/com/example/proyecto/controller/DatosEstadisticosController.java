package com.example.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto.dto.DatosEstadisticos;
import com.example.proyecto.service.DatosEstadisticosServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/datos")
@RequiredArgsConstructor
public class DatosEstadisticosController {

	@Autowired
	private DatosEstadisticosServiceImpl datosEstadisticosServiceImpl;
	
	@GetMapping
    public List<DatosEstadisticos> listarDatos(){
        return datosEstadisticosServiceImpl.listarDatos();
    }
	
	@GetMapping("/{id}")
    public DatosEstadisticos datosID(@PathVariable("id") int codigo){
        return datosEstadisticosServiceImpl.datosID(codigo);
    }
	
    @PostMapping("/add")
    public ResponseEntity<DatosEstadisticos> guardarDato(@RequestBody DatosEstadisticos datos){
        return ResponseEntity.ok(datosEstadisticosServiceImpl.guardarDato(datos));
    }
    
    @PutMapping("/update")
    public ResponseEntity<DatosEstadisticos> actualizarDato(@RequestBody DatosEstadisticos datos){
        return ResponseEntity.ok(datosEstadisticosServiceImpl.actualizarDato(datos));
    }
    
    @DeleteMapping("/{id}")
    public void eliminarDato(@PathVariable("id") int codigo){
    	datosEstadisticosServiceImpl.eliminarDato(codigo);
    }
}
