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

import com.example.proyecto.dto.Roles;
import com.example.proyecto.service.RolServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolController {

	@Autowired
	private RolServiceImpl rolServiceImpl;
	
	@GetMapping
    public List<Roles> listarRoles(){
        return rolServiceImpl.listarRoles();
    }
	
	@GetMapping("/{id}")
    public Roles rolID(@PathVariable("id") int codigo){
        return rolServiceImpl.rolID(codigo);
    }
	
    @PostMapping("/add")
    public ResponseEntity<Roles> guardarRol(@RequestBody Roles rol){
        return ResponseEntity.ok(rolServiceImpl.guardarRol(rol));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Roles> actualizarRol(@RequestBody Roles rol){
        return ResponseEntity.ok(rolServiceImpl.actualizarRol(rol));
    }
    
    @DeleteMapping("/{id}")
    public void eliminarRol(@PathVariable("id") int codigo){
    	rolServiceImpl.eliminarRol(codigo);
    }
}
