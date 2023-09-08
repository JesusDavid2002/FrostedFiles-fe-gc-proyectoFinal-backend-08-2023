package com.example.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto.dto.Files;
import com.example.proyecto.service.FilesServiceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class FileController {

	@Autowired
	private FilesServiceImpl fileServiceImpl;
	
	@GetMapping
    public List<Files> listarFiles(){
        return fileServiceImpl.listarFiles();
    }
	
	@GetMapping("/{id}")
    public Files fileID(@PathVariable("id") int codigo){
        return fileServiceImpl.fileID(codigo);
    }
	
	@GetMapping("/{nombre}")
    public Files fileNombre(@PathVariable("nombre") String nombre){
        return fileServiceImpl.fileNombre(nombre);
    }
	
	@GetMapping("/{extension}")
    public Files fileExtension(@PathVariable("extension") String extension){
        return fileServiceImpl.fileExtension(extension);
    }
	
    @PostMapping("/add")
    public ResponseEntity<Files> guardarFile(@RequestBody Files file){
        return ResponseEntity.ok(fileServiceImpl.guardarFile(file));
    }
    
    @PatchMapping("/{nombre}")
    public ResponseEntity<Files> actualizarFile(@PathVariable("nombre") String nombre, @RequestBody Files file){
        return ResponseEntity.ok(fileServiceImpl.actualizarFile(nombre, file));
    }
       
    @DeleteMapping("/{nombre}")
    @Transactional
    public void eliminarFileByNombre(@PathVariable("nombre") String nombre){
    	fileServiceImpl.eliminarFileByNombre(nombre);
    }
}
