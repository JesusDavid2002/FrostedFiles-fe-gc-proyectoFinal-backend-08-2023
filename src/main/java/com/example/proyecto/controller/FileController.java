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

import com.example.proyecto.dto.Files;
import com.example.proyecto.service.FilesServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class FileController {

	@Autowired
	private FilesServiceImpl categoriesServiceImpl;
	
	@GetMapping
    public List<Files> listarFiles(){
        return categoriesServiceImpl.listarFiles();
    }
	
	@GetMapping("/{id}")
    public Files fileID(@PathVariable("id") int codigo){
        return categoriesServiceImpl.fileID(codigo);
    }
	
    @PostMapping("/add")
    public ResponseEntity<Files> guardarFile(@RequestBody Files file){
        return ResponseEntity.ok(categoriesServiceImpl.guardarFile(file));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Files> actualizarFile(@RequestBody Files file){
        return ResponseEntity.ok(categoriesServiceImpl.actualizarFile(file));
    }
    
    @DeleteMapping("/{id}")
    public void eliminarFile(@PathVariable("id") int codigo){
    	categoriesServiceImpl.eliminarFile(codigo);
    }
}
