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

import com.example.proyecto.dto.Multimedia;
import com.example.proyecto.service.MultimediaServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/multimedia")
@RequiredArgsConstructor
public class MultimediaController {

	@Autowired
	private MultimediaServiceImpl multimediaServiceImpl;
	
	@GetMapping
    public List<Multimedia> listarMultimedia(){
        return multimediaServiceImpl.listarMultimedia();
    }
	
	@GetMapping("/{id}")
    public Multimedia multimediaID(@PathVariable("id") int codigo){
        return multimediaServiceImpl.multimediaID(codigo);
    }
	
    @PostMapping("/add")
    public ResponseEntity<Multimedia> guardarMultimedia(@RequestBody Multimedia multimedia){
        return ResponseEntity.ok(multimediaServiceImpl.guardarMultimedia(multimedia));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Multimedia> actualizarMultimedia(@RequestBody Multimedia multimedia){
        return ResponseEntity.ok(multimediaServiceImpl.actualizarMultimedia(multimedia));
    }
    
    @DeleteMapping("/{id}")
    public void eliminarMultimedia(@PathVariable("id") int codigo){
    	multimediaServiceImpl.eliminarMultimedia(codigo);
    }
}
