package com.example.proyecto.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CompartirFile {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
	private String destinatario;
    private String asunto;
    private String mensaje;
    
    @ManyToOne
    @JoinColumn(name="file_id")
    private Files files;

    public CompartirFile() {}
    
	public CompartirFile(int id, String destinatario, String asunto, String mensaje, Files files) {
		this.id = id;
		this.destinatario = destinatario;
		this.asunto = asunto;
		this.mensaje = mensaje;
		this.files = files;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Files getFiles() {
		return files;
	}

	public void setFiles(Files files) {
		this.files = files;
	}
    
}
