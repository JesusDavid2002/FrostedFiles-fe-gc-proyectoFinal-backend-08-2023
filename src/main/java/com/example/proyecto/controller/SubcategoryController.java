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

import com.example.proyecto.dto.Categories;
import com.example.proyecto.dto.Subcategories;
import com.example.proyecto.service.CategoriesServiceImpl;
import com.example.proyecto.service.SubcategoriesServiceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/subcategories")
@RequiredArgsConstructor
public class SubcategoryController {

	@Autowired
	private SubcategoriesServiceImpl subcategoriesServiceImpl;
	
	@Autowired
	private CategoriesServiceImpl categoriesServiceImpl;
	
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
    	String categoryName = subcategory.getCategories().getNombre();
    	Categories category = categoriesServiceImpl.categoryNombre(categoryName);
    	
    	if(category == null) {
    		Categories newCategory = new Categories();
    		newCategory.setNombre(categoryName);
    		categoriesServiceImpl.guardarCategory(newCategory);
    		subcategory.setCategories(newCategory);
    	} else {
    		subcategory.setCategories(category);
    	}
        return ResponseEntity.ok(subcategoriesServiceImpl.guardarSubcategory(subcategory));
    }
    
    @PutMapping("/{nombre}")
    public ResponseEntity<Subcategories> actualizarSubcategory(@PathVariable("nombre") String nombre, @RequestBody Subcategories subcategory){
    	return ResponseEntity.ok(subcategoriesServiceImpl.actualizarSubcategory(nombre, subcategory));
    }
        
    @DeleteMapping("/{nombre}")
    @Transactional
    public void eliminarSubcategoryXNombre(@PathVariable("nombre") String nombre){
    	subcategoriesServiceImpl.eliminarSubcategoryXNombre(nombre);
    }
}
