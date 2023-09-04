package com.example.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.dto.Multimedia;

public interface IMultimediaDAO extends JpaRepository<Multimedia, Integer> {

}
