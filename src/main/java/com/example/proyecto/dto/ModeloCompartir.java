package com.example.proyecto.dto;

public class ModeloCompartir {
	
	private String destinatario;
	private String asunto;
	private String mensaje;
	
	public ModeloCompartir() {}
	
	public ModeloCompartir(String destinatario, String asunto, String mensaje) {
		this.destinatario = destinatario;
		this.asunto = asunto;
		this.mensaje = mensaje;
	}
	
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
