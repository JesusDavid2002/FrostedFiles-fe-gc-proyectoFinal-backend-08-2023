package com.example.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.dto.Comentarios;

public interface IComentariosDAO  extends JpaRepository<Comentarios, Integer>{

}
