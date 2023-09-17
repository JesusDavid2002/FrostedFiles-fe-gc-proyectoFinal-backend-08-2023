package com.example.proyecto.service;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.proyecto.dao.IFilesDAO;
import com.example.proyecto.dto.Acciones;
import com.example.proyecto.dto.Files;
import com.example.proyecto.dto.ModeloCompartir;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class CompartirFileServiceImpl {

	@Autowired
	private JavaMailSender enviarEmail;
	
	@Autowired
	private AccionesServiceImpl accionesServiceImpl; 
	
	@Autowired
	private FilesServiceImpl fileServiceImpl; 
			
	public void compartirArchivo(ModeloCompartir modelo) throws Exception {
		
        try {
            MimeMessage mensajes = enviarEmail.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mensajes, true);

            if (modelo.getFile() != null && !modelo.getFile().isEmpty()) {
            	Files contenidoFile = convertidorAFiles(modelo.getFile());
            	
                if (contenidoFile != null) {
                    helper.setTo(modelo.getDestinatario());
                    helper.setSubject(modelo.getAsunto());
                    helper.setText(modelo.getMensaje());

                    String nombre = contenidoFile.getNombre();
                    String extension = contenidoFile.getExtension();
                    ByteArrayResource archivoBytes = new ByteArrayResource(contenidoFile.getContenido());
                    helper.addAttachment(nombre + "." + extension, archivoBytes);
                    
                    Files file = new Files();
                    file.setNombre(nombre);
                    file.setExtension(extension);
                    file.setTamano(contenidoFile.getTamano());
                    file.setFechaSubida(contenidoFile.getFechaSubida());
                    file.setVisibilidad(contenidoFile.isVisibilidad());
                    file.setContenido(contenidoFile.getContenido());
                    file.setCategories(contenidoFile.getCategories());
                    file.setSubcategories(contenidoFile.getSubcategories());

        	    	file = fileServiceImpl.guardarFile(file);
                    Acciones accion = new Acciones("compartir", LocalDateTime.now(), file);
                	accionesServiceImpl.guardarAccion(accion);
                	
                } else {
                    throw new Exception("Archivo no encontrado");
                }
                
            } else {
                throw new Exception("El modelo no contiene un archivo adjunto válido");
            }

            enviarEmail.send(mensajes);
        } catch (Exception e) {
            throw new Exception("Error al compartir archivo", e);
        }
	}

	private Files convertidorAFiles(MultipartFile file) throws IOException{
		Files files = new Files();
		String nombre = file.getOriginalFilename();
		int separacion = nombre.lastIndexOf('.');
		
		files.setNombre(file.getOriginalFilename());
		if(separacion > 0) {
			String extension = nombre.substring(separacion + 1);
			files.setExtension(extension);
		}
		
		files.setTamano(file.getSize());
		//files.setFechaSubida(new LocalDateTime("2023-09-06","14:30:00"));
		files.setContenido(file.getBytes());
		return files;
	}

}
