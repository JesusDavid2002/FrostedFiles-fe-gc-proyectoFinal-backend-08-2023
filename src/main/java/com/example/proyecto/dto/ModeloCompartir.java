package com.example.proyecto.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModeloCompartir {
	
	private String destinatario;
	private String asunto;
	private String mensaje;
	private MultipartFile file;
	
	
}
