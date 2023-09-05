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

import com.example.proyecto.dto.Users;
import com.example.proyecto.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/users")
    public List<Users> getAllUsers(){
        return userServiceImpl.listarUsuarios();
    }
	
	@GetMapping("/{email}")
    public Users getByEmail(@PathVariable("email") String email){
        return userServiceImpl.usuarioEmail(email);
    }
	
    @PostMapping("/add")
    public ResponseEntity<Users> guardarUsuario(@RequestBody Users user){
        return ResponseEntity.ok(userServiceImpl.guardarUsuario(user));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Users> update(@RequestBody Users user){
        return ResponseEntity.ok(userServiceImpl.actualizarUsuario(user));
    }
    
    @DeleteMapping("/{email}")
    public void eliminarUsuarioXEmail(@PathVariable("email") String email){
    	userServiceImpl.eliminarUsuarioXEmail(email);
    }

   
}
