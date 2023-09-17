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
	
	@GetMapping("/id/{id}")
    public Subcategories subcategoryID(@PathVariable("id") int codigo){
        return subcategoriesServiceImpl.subcategoryID(codigo);
    }
	
    @PostMapping("/add")
    @Transactional
    public ResponseEntity<Subcategories> guardarSubcategory(@RequestBody Subcategories subcategory){
        if(subcategory == null || subcategory.getCategory() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        
        String categoryName = subcategory.getCategory().getNombre();
        Categories category = categoriesServiceImpl.categoryNombre(categoryName);
        
        if(category == null) {
            Categories newCategory = new Categories();
            newCategory.setNombre(categoryName);
            categoriesServiceImpl.guardarCategory(newCategory);
            category = categoriesServiceImpl.categoryNombre(categoryName);
        }

        subcategory.setCategory(category);
        return ResponseEntity.ok(subcategoriesServiceImpl.guardarSubcategory(subcategory));
    }

    
    @GetMapping("/{nombre}")
	public List<Subcategories> subcategoryName(@PathVariable("nombre") String nombre) {
	    return subcategoriesServiceImpl.findByCategory_Nombre(nombre);
	}
        
    @DeleteMapping("/{nombre}")
    @Transactional
    public void eliminarSubcategoryXNombre(@PathVariable("nombre") String nombre){
    	subcategoriesServiceImpl.eliminarSubcategoryXNombre(nombre);
    }
}
