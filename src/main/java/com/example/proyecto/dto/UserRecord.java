package com.example.proyecto.dto;

import java.time.LocalDateTime;
import java.sql.Blob;

public record UserRecord (int id, String nombre, String email, String password, LocalDateTime fecha, String descripcion,
		Blob fotoPerfil, Blob fotoPortada) {}
