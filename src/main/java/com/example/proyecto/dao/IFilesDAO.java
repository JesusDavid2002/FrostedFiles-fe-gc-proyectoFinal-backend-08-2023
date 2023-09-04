package com.example.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.dto.Files;

public interface IFilesDAO  extends JpaRepository<Files, Integer>{

}
