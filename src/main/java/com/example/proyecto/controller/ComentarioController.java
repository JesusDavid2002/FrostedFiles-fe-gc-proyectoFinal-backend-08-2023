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

import com.example.proyecto.dto.Comentarios;
import com.example.proyecto.service.ComentariosServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/comentarios")
@RequiredArgsConstructor
public class ComentarioController {

	@Autowired
	private ComentariosServiceImpl comentariosServiceImpl;
	
	@GetMapping
    public List<Comentarios> listarCategories(){
        return comentariosServiceImpl.listarComentarios();
    }
	
	@GetMapping("/{id}")
    public Comentarios categoryID(@PathVariable("id") int codigo){
        return comentariosServiceImpl.comentarioID(codigo);
    }
	
    @PostMapping("/add")
    public ResponseEntity<Comentarios> guardarComentario(@RequestBody Comentarios comentario){
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
