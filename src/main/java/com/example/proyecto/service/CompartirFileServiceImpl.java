package com.example.proyecto.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.proyecto.dao.IFilesDAO;
import com.example.proyecto.dto.Files;
import com.example.proyecto.dto.ModeloCompartir;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class CompartirFileServiceImpl {

	@Autowired
	private JavaMailSender enviarEmail;
	
	@Autowired
	private IFilesDAO iFiles;
		
	public void compartirArchivo(ModeloCompartir modelo, UserDetails user) throws Exception {
		
		 if (user != null) {
		        try {
		            MimeMessage mensajes = enviarEmail.createMimeMessage();
		            MimeMessageHelper helper = new MimeMessageHelper(mensajes, true);

		            // Verificar si el modelo tiene un archivo adjunto válido
		            if (modelo.getFile() != null) {
		                Files contenidoFile = iFiles.findByNombre(modelo.getFile().getNombre());

		                if (contenidoFile != null) {
		                    helper.setFrom(new InternetAddress(user.getUsername()));
		                    helper.setTo(modelo.getDestinatario());
		                    helper.setSubject(modelo.getAsunto());
		                    helper.setText(modelo.getMensaje());

		                    String nombre = contenidoFile.getNombre();
		                    String extension = contenidoFile.getExtension();
		                    ByteArrayResource archivoBytes = new ByteArrayResource(contenidoFile.getContenido());
		                    helper.addAttachment(nombre + "." + extension, archivoBytes);
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
		    } else {
		        throw new Exception("Usuario no autenticado");
		    }
		
	}

}
