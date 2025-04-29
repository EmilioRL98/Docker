package com.practica.libros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practica.libros.model.Libro;
import com.practica.libros.repo.LibroRepo;
import com.practica.libros.controller.AutoIncrementService;


@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://frontend:80"}) // Permite solicitudes desde Angular
public class ApiAngularController {
    
    @Autowired
    private LibroRepo libroRepo;

    @Autowired
    private AutoIncrementService autoIncrementService; // Inyección de AutoIncrementService

    @GetMapping(value = "/")
    public String getPage() {
        return "Bienvenido a la biblioteca!!";
    }

    @GetMapping(value = "/libros")
    public List<Libro> getLibros() {
        return libroRepo.findAll();
    }
    
    @GetMapping("/libros/{id}")
    public Libro getLibro(@PathVariable long id) {
        return libroRepo.findById(id).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    @PostMapping(value = "/guardar")
    public String saveLibro(@RequestBody Libro libro) {
        libroRepo.save(libro);
        return "Libro añadido";
    }

    @PutMapping(value = "/actualizar/{id}")
    public String updateLibro(@PathVariable long id, @RequestBody Libro libro) {
        Libro updatedLibro = libroRepo.findById(id).get();
        updatedLibro.setAutor(libro.getAutor());
        updatedLibro.setTitulo(libro.getTitulo());
        updatedLibro.setGenero(libro.getGenero());
        updatedLibro.setFechaPublicacion(libro.getFechaPublicacion());

        libroRepo.save(updatedLibro);

        return "Libro actualizado";
    }

    @DeleteMapping(value = "/borrar/{id}")
    public String deleteLibro(@PathVariable long id) {
        Libro libroDeleted = libroRepo.findById(id).get();
        libroRepo.delete(libroDeleted);

        autoIncrementService.ajustarAutoIncrement();

        return "Libro eliminado";
    }

}
