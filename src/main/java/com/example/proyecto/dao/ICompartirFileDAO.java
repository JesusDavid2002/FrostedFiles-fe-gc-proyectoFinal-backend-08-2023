package com.example.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.dto.CompartirFile;

public interface ICompartirFileDAO extends JpaRepository<CompartirFile, Integer>{

}
