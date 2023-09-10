package com.example.proyecto.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.proyecto.dto.Categories;
import com.example.proyecto.dto.Files;
import com.example.proyecto.dto.ModeloCompartir;
import com.example.proyecto.dto.Subcategories;
import com.example.proyecto.service.CompartirFileServiceImpl;
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
	
	@Autowired
	private CompartirFileServiceImpl compartirServiceImpl;
	
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
        return fileServiceImpl.fileNombre(nombre);
    }
	
	@GetMapping("/extension/{extension}")
    public Files fileExtension(@PathVariable("extension") String extension){
        return fileServiceImpl.fileExtension(extension);
    }
	
//	@GetMapping("/descargar/{nombre}")
//	public ResponseEntity<InputStreamResource> descargarFile(@PathVariable("nombre") String nombre){
//		Files files = fileServiceImpl.fileNombre(nombre);
//		
//		InputStreamResource dato = new InputStreamResource(files.getInputStream());
//		
//		return ResponseEntity.ok()
//				.header("Content", "; Nombre del fichero = " +files.getNombre())
//				.contentType(MediaType.parseMediaType(files.getC))
//    }
	
    @PostMapping(value="/add", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Files> guardarFile(@RequestParam("contenido") MultipartFile file,
    	    @RequestParam("nombre") String nombre,
    	    @RequestParam("extension") String extension,
    	    @RequestParam("tamano") BigDecimal tamano,
    	    @RequestParam("fechaSubida") LocalDateTime fechaSubida,
    	    @RequestParam("visibilidad") boolean visibilidad,
    	    @RequestParam("categories") String nombreCategoria,
    		@RequestParam("subcategories") String nombreSubcategoria){
    	
		try {
			byte[] contenido = file.getBytes();
			Categories categories = null;
			Subcategories subcategories = null;
		
			if (nombreCategoria != null && !nombreCategoria.isEmpty()) {
	            Optional<Categories> optionalCategory = category.findByNombre(nombreCategoria);
	            categories = optionalCategory.orElseGet(() -> new Categories(nombreCategoria));
	        } 
			if (nombreSubcategoria != null && !nombreSubcategoria.isEmpty()) {
	            Optional<Subcategories> optionalSubcategory = subcategory.findByNombre(nombreSubcategoria);
	            subcategories = optionalSubcategory.orElseGet(() -> new Subcategories(nombreSubcategoria));
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
	    		        
	        return ResponseEntity.ok(fileServiceImpl.guardarFile(newFile));
	        
		} catch (IOException e) {
			e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    	
    }
    
    @PostMapping("/compartir")
    public ResponseEntity<String> compartirArchivo(@RequestBody ModeloCompartir request, @AuthenticationPrincipal UserDetails user) throws Exception{
    	try {
		compartirServiceImpl.compartirArchivo(request, user);
		
        return ResponseEntity.ok("Archivo compartido");
				
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
