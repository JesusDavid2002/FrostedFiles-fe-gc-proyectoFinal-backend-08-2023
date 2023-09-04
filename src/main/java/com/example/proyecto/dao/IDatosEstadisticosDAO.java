package com.example.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.dto.DatosEstadisticos;

public interface IDatosEstadisticosDAO extends JpaRepository<DatosEstadisticos, Integer>{

}
