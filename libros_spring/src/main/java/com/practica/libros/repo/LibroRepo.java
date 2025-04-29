package com.practica.libros.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica.libros.model.Libro;

@Repository
public interface LibroRepo extends JpaRepository<Libro, Long>{

	 List<Libro> findByAutor(String autor);
}
