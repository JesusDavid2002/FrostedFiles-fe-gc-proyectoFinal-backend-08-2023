package com.example.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.dto.Categories;

public interface ICategoriesDAO  extends JpaRepository<Categories, Integer>{

}
