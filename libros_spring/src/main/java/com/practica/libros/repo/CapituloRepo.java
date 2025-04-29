package com.practica.libros.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica.libros.model.Capitulo;

@Repository
public interface CapituloRepo extends JpaRepository<Capitulo, Long>{

}
