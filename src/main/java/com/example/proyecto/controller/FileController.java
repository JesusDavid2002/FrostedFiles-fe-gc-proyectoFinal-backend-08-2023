package com.example.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto.dao.ICategoriesDAO;
import com.example.proyecto.dao.ISubcategoriesDAO;
import com.example.proyecto.dto.Categories;
import com.example.proyecto.dto.Files;
import com.example.proyecto.dto.Subcategories;
import com.example.proyecto.service.FilesServiceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class FileController {

	@Autowired
	private FilesServiceImpl fileServiceImpl;
	
	@Autowired
	private ICategoriesDAO category;
	
	@Autowired
	private ISubcategoriesDAO subcategory;
	
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
    	
    	 // Verificar si se proporciona una categoría
        if (file.getCategories() != null && file.getCategories().getNombre() != null) {
            Optional<Categories> optionalCategory = category.findByNombre(file.getCategories().getNombre());
            Categories existingCategory;
            if (optionalCategory.isPresent()) {
                existingCategory = optionalCategory.get();
            } else {
                // Si la categoría no existe, crear una nueva instancia
                existingCategory = new Categories(file.getCategories().getNombre());
            }
            file.setCategories(existingCategory);
        } else {
            file.setCategories(null);
        }

        // Verificar si se proporciona una subcategoría
        if (file.getSubcategories() != null && file.getSubcategories().getNombre() != null) {
            Optional<Subcategories> optionalSubcategory = subcategory.findByNombre(file.getSubcategories().getNombre());
            Subcategories existingSubcategory;
            if (optionalSubcategory.isPresent()) {
                existingSubcategory = optionalSubcategory.get();
            } else {
                // Si la subcategoría no existe, crear una nueva instancia
                existingSubcategory = new Subcategories(file.getSubcategories().getNombre());
            }
            file.setSubcategories(existingSubcategory);
        } else {
            file.setSubcategories(null);
        }

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
