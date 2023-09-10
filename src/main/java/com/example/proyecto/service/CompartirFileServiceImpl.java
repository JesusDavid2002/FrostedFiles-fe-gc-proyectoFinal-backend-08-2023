package com.example.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.proyecto.dto.Files;
import com.example.proyecto.dto.ModeloCompartir;

import jakarta.mail.internet.MimeMessage;

@Service
public class CompartirFileServiceImpl {

	@Autowired
	private JavaMailSender enviarEmail;
	
	
	public void compartirArchivo(ModeloCompartir modelo, Files file) throws Exception {
		try {
			MimeMessage mensajes = enviarEmail.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mensajes, true);
			
			//helper.setFrom();
			helper.setTo(modelo.getDestinatario());
			helper.setSubject(modelo.getAsunto());
			helper.setText(modelo.getMensaje());
			
			ByteArrayResource archivoBytes = new ByteArrayResource(file.getContenido());
			helper.addAttachment(file.getNombre() + "." + file.getExtension(), archivoBytes);
			enviarEmail.send(mensajes);
		} catch(Exception e) {
			throw new Exception("Error al compartir archivo",e);
		}
	}

}
