package com.example.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto.dao.UserRepository;
import com.example.proyecto.dto.Roles;
import com.example.proyecto.dto.Users;
import com.example.proyecto.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/users")
@RequiredArgsConstructor
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping
    public List<Users> getAllUsers(){
        return userServiceImpl.listarUsuarios();
    }
	
	@GetMapping("/{email}")
    public Users getByUsername(@PathVariable("email") String email){
        return userServiceImpl.usuarioEmail(email);
    }
    
	@PutMapping("/{email}")
	public ResponseEntity<Users> update(@PathVariable(name="email") String email, @RequestBody Users user){
	
			Users user_seleccionado = new Users();
			Users user_actualizado = new Users();
			
			user_seleccionado = userServiceImpl.usuarioEmail(email);
			
			user_actualizado.setRoles(user.getRoles());
			user_actualizado.setNombre(user.getNombre());
			user_actualizado.setPassword(user.getPassword());
			user_actualizado.setFechaCreacion(user.getFechaCreacion());
			
			user_actualizado = userServiceImpl.actualizarUsuario(user_seleccionado);
	        return ResponseEntity.ok(user_actualizado);
		
    }
    
    @DeleteMapping("/{email}")
    public void eliminarUsuarioXEmail(@PathVariable("email") String email){
    	userServiceImpl.eliminarUsuarioXEmail(email);
    }

}
