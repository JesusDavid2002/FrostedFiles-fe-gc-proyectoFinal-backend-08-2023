package com.example.proyecto.dto;

import java.time.LocalDateTime;

public record UserRecord (int id, String nombre, String email, String password, LocalDateTime fecha) {}
