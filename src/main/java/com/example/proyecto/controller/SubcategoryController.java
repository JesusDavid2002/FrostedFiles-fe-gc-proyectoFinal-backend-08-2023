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

import com.example.proyecto.dto.Subcategories;
import com.example.proyecto.service.SubcategoriesServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/subcategories")
@RequiredArgsConstructor
public class SubcategoryController {

	@Autowired
	private SubcategoriesServiceImpl subcategoriesServiceImpl;
	
	@GetMapping
    public List<Subcategories> listarSubcategories(){
        return subcategoriesServiceImpl.listarSubcategories();
    }
	
	@GetMapping("/{id}")
    public Subcategories subcategoryID(@PathVariable("id") int codigo){
        return subcategoriesServiceImpl.subcategoryID(codigo);
    }
	
    @PostMapping("/add")
    public ResponseEntity<Subcategories> guardarSubcategory(@RequestBody Subcategories subcategory){
        return ResponseEntity.ok(subcategoriesServiceImpl.guardarSubcategory(subcategory));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Subcategories> actualizarSubcategory(@RequestBody Subcategories subcategory){
        return ResponseEntity.ok(subcategoriesServiceImpl.actualizarSubcategory(subcategory));
    }
    
    @DeleteMapping("/{id}")
    public void eliminarSubcategory(@PathVariable("id") int codigo){
    	subcategoriesServiceImpl.eliminarSubcategory(codigo);
    }
}
