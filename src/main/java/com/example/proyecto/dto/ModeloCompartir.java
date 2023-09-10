package com.example.proyecto.dto;

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
	private String nombreArchivo;
	private Files file;
	
	
}
