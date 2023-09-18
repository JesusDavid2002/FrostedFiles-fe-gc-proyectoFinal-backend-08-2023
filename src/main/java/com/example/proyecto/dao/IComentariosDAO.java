package com.example.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.dto.Comentarios;
import com.example.proyecto.dto.Users;

public interface IComentariosDAO  extends JpaRepository<Comentarios, Integer>{

}
