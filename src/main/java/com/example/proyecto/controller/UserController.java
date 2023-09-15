package com.example.proyecto.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.proyecto.dto.Users;
import com.example.proyecto.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/admin/users")
    public List<Users> getAllUsers(){
        return userServiceImpl.listarUsuarios();
    }
	
	@GetMapping("/admin/users/{email}")
    public Users getByUsername(@PathVariable("email") String email){
        return userServiceImpl.usuarioEmail(email);
    }
    
	@PatchMapping("/admin/users/{email}")
	public ResponseEntity<Users> updateAdmin(@PathVariable(name="email") String email, @RequestBody Users user){
	
			Users user_seleccionado = userServiceImpl.usuarioEmail(email);	
			
			user_seleccionado.setRoles(user.getRoles());
			
			Users user_actualizado = userServiceImpl.actualizarUsuario(user_seleccionado);
	        return ResponseEntity.ok(user_actualizado);
		
    }
	
	@PatchMapping("/users/{email}")
	public ResponseEntity<Users> updateUser(@PathVariable(name="email") String email, 
			@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("fotoPerfil") MultipartFile fotoPerfil,
			@RequestParam("fotoPortada") MultipartFile fotoPortada) throws IOException{
	
			Users user_seleccionado = userServiceImpl.usuarioEmail(email);	
			byte[] foto = fotoPerfil.getBytes();
			byte[] fotoPort = fotoPortada.getBytes();
			
			user_seleccionado.setNombre(nombre);
			user_seleccionado.setDescripcion(descripcion);
			user_seleccionado.setFotoPerfil(foto);
			user_seleccionado.setFotoPortada(fotoPort);
			
			Users user_actualizado = userServiceImpl.actualizarUsuario(user_seleccionado);
	        return ResponseEntity.ok(user_actualizado);
    }
    
    @DeleteMapping("/admin/users/{email}")
    public void eliminarUsuarioXEmail(@PathVariable("email") String email){
    	userServiceImpl.eliminarUsuarioXEmail(email);
    }

}
