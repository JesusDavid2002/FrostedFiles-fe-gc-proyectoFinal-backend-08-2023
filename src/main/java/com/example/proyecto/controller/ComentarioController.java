package com.example.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto.auth.AuthService;
import com.example.proyecto.dao.IFilesDAO;
import com.example.proyecto.dao.IUserDAO;
import com.example.proyecto.dao.UserRepository;
import com.example.proyecto.dto.Comentarios;
import com.example.proyecto.dto.Files;
import com.example.proyecto.dto.Users;
import com.example.proyecto.service.ComentariosServiceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/comentarios")
@RequiredArgsConstructor
public class ComentarioController {

	@Autowired
	private ComentariosServiceImpl comentariosServiceImpl;
	
	@Autowired
	private IFilesDAO iFiles;
	
	@Autowired
	private IUserDAO iUsers;
		
	@GetMapping
    public List<Comentarios> listarCategories(){
        return comentariosServiceImpl.listarComentarios();
    }
	
	@GetMapping("/{id}")
    public Comentarios categoryID(@PathVariable("id") int codigo){
        return comentariosServiceImpl.comentarioID(codigo);
    }
	
    @PostMapping("/add")
    @Transactional
    public ResponseEntity<Comentarios> guardarComentario(@RequestBody Comentarios comentario){

	    	String nombreArchivo = comentario.getFiles().getNombre();
	        Files files = iFiles.findByNombre(nombreArchivo);
	        
	    	comentario.setFiles(files);
    	
    	return ResponseEntity.ok(comentariosServiceImpl.guardarComentario(comentario));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Comentarios> actualizarComentario(@RequestBody Comentarios comentario){
        return ResponseEntity.ok(comentariosServiceImpl.actualizarComentario(comentario));
    }
    
    @DeleteMapping("/{id}")
    public void eliminarComentario(@PathVariable("id") int codigo){
    	comentariosServiceImpl.eliminarComentario(codigo);
    }
}
