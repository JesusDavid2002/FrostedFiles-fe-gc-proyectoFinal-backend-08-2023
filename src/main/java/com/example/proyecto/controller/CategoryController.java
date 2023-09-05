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

import com.example.proyecto.dto.Categories;
import com.example.proyecto.service.CategoriesServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
	
	@Autowired
	private CategoriesServiceImpl categoriesServiceImpl;
	
	@GetMapping
    public List<Categories> listarCategories(){
        return categoriesServiceImpl.listarCategories();
    }
	
	@GetMapping("/{id}")
    public Categories categoryID(@PathVariable("id") int codigo){
        return categoriesServiceImpl.categoryID(codigo);
    }
	
    @PostMapping("/add")
    public ResponseEntity<Categories> guardarCategory(@RequestBody Categories category){
        return ResponseEntity.ok(categoriesServiceImpl.guardarCategory(category));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Categories> actualizarCategory(@RequestBody Categories category){
        return ResponseEntity.ok(categoriesServiceImpl.actualizarCategory(category));
    }
    
    @DeleteMapping("/{id}")
    public void eliminarCategory(@PathVariable("id") int codigo){
    	categoriesServiceImpl.eliminarCategory(codigo);
    }
}
