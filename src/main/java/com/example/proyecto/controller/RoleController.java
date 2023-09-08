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
import com.example.proyecto.service.RolesServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/roles")
@RequiredArgsConstructor
public class RoleController {

	@Autowired
	private RolesServiceImpl rolesServiceImpl;
	
	@GetMapping
    public List<Roles> listarRoles(){
        return rolesServiceImpl.listarRoles();
    }
	
	@GetMapping("/{nombre}")
    public Roles rolNombre(@PathVariable("nombre") String nombre){
        return rolesServiceImpl.rolNombre(nombre);
    }
	
    @PostMapping("/add")
    public ResponseEntity<Roles> guardarRol(@RequestBody Roles rol){
        return ResponseEntity.ok(rolesServiceImpl.guardarRol(rol));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Roles> actualizarRol(@RequestBody Roles rol){
        return ResponseEntity.ok(rolesServiceImpl.actualizarRol(rol));
    }
    
    @DeleteMapping("/{nombre}")
    public void eliminarRolXNombre(@PathVariable("nombre") String nombre){
    	rolesServiceImpl.eliminarRolXNombre(nombre);
    }
}
