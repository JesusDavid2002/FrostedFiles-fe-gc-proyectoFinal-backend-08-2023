package com.example.proyecto.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
