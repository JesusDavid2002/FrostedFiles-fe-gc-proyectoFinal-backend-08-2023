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

import com.example.proyecto.dto.Acciones;
import com.example.proyecto.service.AccionesServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/acciones")
@RequiredArgsConstructor
public class AccionController {

	@Autowired
	private AccionesServiceImpl accionesServiceImpl;
	
	@GetMapping
    public List<Acciones> listarAcciones(){
        return accionesServiceImpl.listarAcciones();
    }
	
	@GetMapping("/{id}")
    public Acciones accionID(@PathVariable("id") int codigo){
        return accionesServiceImpl.accionID(codigo);
    }
	
    @PostMapping("/add")
    public ResponseEntity<Acciones> guardarAccion(@RequestBody Acciones accion){
        return ResponseEntity.ok(accionesServiceImpl.guardarAccion(accion));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Acciones> actualizarAccion(@RequestBody Acciones accion){
        return ResponseEntity.ok(accionesServiceImpl.actualizarAccion(accion));
    }
    
    @DeleteMapping("/{id}")
    public void eliminarAcciones(@PathVariable("id") int codigo){
    	accionesServiceImpl.eliminarAccion(codigo);
    }

}
