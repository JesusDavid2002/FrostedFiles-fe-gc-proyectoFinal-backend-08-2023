package com.example.proyecto.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.proyecto.dao.ICategoriesDAO;
import com.example.proyecto.dao.ISubcategoriesDAO;
import com.example.proyecto.dto.Acciones;
import com.example.proyecto.dto.Categories;
import com.example.proyecto.dto.Files;
import com.example.proyecto.dto.ModeloCompartir;
import com.example.proyecto.dto.Subcategories;
import com.example.proyecto.service.AccionesServiceImpl;
import com.example.proyecto.service.CategoriesServiceImpl;
import com.example.proyecto.service.CompartirFileServiceImpl;
import com.example.proyecto.service.FilesServiceImpl;
import com.example.proyecto.service.SubcategoriesServiceImpl;

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

	@Autowired
	private CategoriesServiceImpl categoryServiceImpl;
	
	@Autowired
	private SubcategoriesServiceImpl subcategoryServiceImpl;
	
	@Autowired
	private CompartirFileServiceImpl compartirServiceImpl; 

	@Autowired
	private AccionesServiceImpl accionesServiceImpl; 

	@GetMapping
    public List<Files> listarFiles(){
        return fileServiceImpl.listarFiles();
    }
	
	@GetMapping("/id/{id}")
    public Files fileID(@PathVariable("id") int codigo){
        return fileServiceImpl.fileID(codigo);
    }
		
	@GetMapping("/nombre/{nombre}")
    public Files fileNombre(@PathVariable("nombre") String nombre){
		Files verFile = fileServiceImpl.fileNombre(nombre);
    	accionesServiceImpl.guardarAccion("visualizar", verFile.getFechaSubida(), verFile);
    	
        return verFile;
    }
	
	@GetMapping("/extension/{extension}")
    public Files fileExtension(@PathVariable("extension") String extension){
		return  fileServiceImpl.fileExtension(extension);      
    }
	
	@GetMapping("/categories/{categories}")
    public ResponseEntity<List<Files>> fileCategory(@PathVariable("categories") String categoriaNombre){
		List<Files> files = categoryServiceImpl.getFilesByCategory(categoriaNombre);
		
		if(!files.isEmpty()) {
			return ResponseEntity.ok(files);
		} else {
			return ResponseEntity.notFound().build();
		}
    }
	
	@GetMapping("/subcategories/{subcategories}")
    public ResponseEntity<List<Files>> fileSubcategory(@PathVariable("subcategories") String subcategoriaNombre){
		List<Files> files = subcategoryServiceImpl.getFilesBySubcategory(subcategoriaNombre);
		
		if(!files.isEmpty()) {
			return ResponseEntity.ok(files);
		} else {
			return ResponseEntity.notFound().build();
		}
    }
	
    @PostMapping(value="/add", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Files> guardarFile(@RequestParam("file") MultipartFile file,
    	    @RequestParam("nombre") String nombre,
    	    @RequestParam("extension") String extension,
    	    @RequestParam("tamano") long tamano,
    	    @RequestParam("fechaSubida") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaSubida,
    	    @RequestParam("visibilidad") boolean visibilidad,
    	    @RequestParam("categories") String nombreCategoria,
    		@RequestParam("subcategories") String nombreSubcategoria){
    	
		try {
			byte[] contenido = file.getBytes();		
	        
			Categories categories = null;
			Subcategories subcategories = null;
	        
			if (nombreCategoria != null && !nombreCategoria.isEmpty()) {
			    Optional<Categories> optionalCategory = category.findByNombre(nombreCategoria);
			    if (optionalCategory.isPresent()) {
			        categories = optionalCategory.get();
			    } else {
			        categories = new Categories(nombreCategoria);
			        category.save(categories); //Guardar en la base de datos
			    }
			} 
			if (nombreSubcategoria != null && !nombreSubcategoria.isEmpty()) {
			    Optional<Subcategories> optionalSubcategory = subcategory.findByNombre(nombreSubcategoria);
			    if (optionalSubcategory.isPresent()) {
			        subcategories = optionalSubcategory.get();
			    } else {
			        subcategories = new Subcategories(nombreSubcategoria);
			        subcategory.save(subcategories); //Guardar en la base de datos
			    }
			} 
						
			Files newFile = new Files();
	    	newFile.setNombre(nombre);
	    	newFile.setTamano(tamano);
	    	newFile.setExtension(extension);
	    	newFile.setFechaSubida(fechaSubida);
	    	newFile.setVisibilidad(visibilidad);
	    	newFile.setContenido(contenido);
	    	newFile.setCategories(categories);
	    	newFile.setSubcategories(subcategories);
	    	
	    	newFile = fileServiceImpl.guardarFile(newFile);
	    	accionesServiceImpl.guardarAccion("subir", fechaSubida, newFile);
	    	
	        return ResponseEntity.ok(newFile);
	        
		} catch (IOException e) {
			e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    	
    }
    
    @GetMapping("/pdf/{nombre}")
    public ResponseEntity<byte[]> getPdfByName(@PathVariable("nombre") String nombre) {
        Files pdfEntity = fileServiceImpl.fileNombre(nombre); 

        if (pdfEntity != null) {
            byte[] pdfBytes = pdfEntity.getContenido(); 

            return ResponseEntity
                    .ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdfBytes);
        } else {
        	return ResponseEntity
                  .status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body(null);
        }
    }
    
	@PostMapping(value="/compartir", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Map<String, String>> compartirArchivo(@RequestParam("archivo") MultipartFile file,
            @RequestParam("destinatario") String destinatario,
            @RequestParam("asunto") String asunto,
            @RequestParam("mensaje") String mensaje,
            @AuthenticationPrincipal UserDetails user) throws Exception{
    	try {
    		ModeloCompartir request = new ModeloCompartir(destinatario,asunto,mensaje,file);
    		
    		compartirServiceImpl.compartirArchivo(request);
    		Map<String, String> response = new HashMap<>();
            response.put("message", "Archivo compartido exitosamente");
            
            return ResponseEntity.ok(response);
				
    	} catch (IOException e) {
			e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
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
