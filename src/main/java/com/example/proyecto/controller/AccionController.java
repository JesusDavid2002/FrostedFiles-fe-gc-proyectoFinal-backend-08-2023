package com.example.proyecto.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.example.proyecto.dao.IFilesDAO;
import com.example.proyecto.dao.UserRepository;
import com.example.proyecto.dto.Acciones;
import com.example.proyecto.dto.Files;
import com.example.proyecto.dto.Users;
import com.example.proyecto.service.AccionesServiceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/acciones")
@RequiredArgsConstructor
public class AccionController {

	@Autowired
	private AccionesServiceImpl accionesServiceImpl;

	@Autowired
	private IFilesDAO iFiles;
	
	@GetMapping
    public List<Acciones> listarAcciones(){
        return accionesServiceImpl.listarAcciones();
    }
	
	@GetMapping("/{id}")
    public Acciones accionID(@PathVariable("id") int codigo){
        return accionesServiceImpl.accionID(codigo);
    }
	
	@GetMapping("/estadisticasMensuales")
    public ResponseEntity<Map<String, Map<String, Integer>>> obtenerEstadisiticasMensuales(){
		List<Acciones> acciones = accionesServiceImpl.listarAcciones();

		Map<String, Map<String, Integer>> estadisticas = accionesServiceImpl.obtenerEstadisiticasMensuales(acciones);
		
        return ResponseEntity.ok(estadisticas);
    }
	
	@GetMapping("/estadisticasAnuales")
    public ResponseEntity<Map<String, Map<String, Integer>>> obtenerEstadisiticasAnuales(){
		List<Acciones> acciones = accionesServiceImpl.listarAcciones();

		Map<String, Map<String, Integer>> estadisticas = accionesServiceImpl.obtenerEstadisiticasAnuales(acciones);
		
        return ResponseEntity.ok(estadisticas);
    }
    

	@PostMapping("/add")
    public ResponseEntity<Acciones> guardarAccion(@RequestBody Acciones accion){
    	
            String nombreArchivo = accion.getFiles().getNombre();
            Files files = iFiles.findByNombre(nombreArchivo);
            
            if (files == null) {
                throw new EntityNotFoundException("El archivo con nombre " + nombreArchivo + " no existe.");
            }
            
            accion.setFiles(files);   

            Acciones accionGuardada = accionesServiceImpl.guardarAccion(accion);
            return ResponseEntity.ok(accionGuardada);
         
        
    }
    
    @PutMapping("/update")
    public ResponseEntity<Acciones> actualizarAccion(@RequestBody Acciones accion){
    	
        return ResponseEntity.ok(accionesServiceImpl.actualizarAccion(accion));
    }
    
    @DeleteMapping("/{id}")
    public void eliminarAcciones(@PathVariable("id") int codigo){
    	accionesServiceImpl.eliminarAccion(codigo);
    }

}
