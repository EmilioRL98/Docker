package com.practica.libros.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practica.libros.model.Libro;
import com.practica.libros.repo.LibroRepo;

@Service
public class LibroService {

    private final LibroRepo libroRepo;

    public LibroService(LibroRepo libroRepo) {
        this.libroRepo = libroRepo;
    }

    public List<Libro> findAllLibros() {
        return libroRepo.findAll();
    }

    public Libro createLibro(Libro libro) {
        return libroRepo.save(libro);
    }

    public Libro updateLibro(Long id, Libro libro) {
        Libro existingLibro = libroRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro con ID " + id + " no encontrado"));
        existingLibro.setTitulo(libro.getTitulo());
        existingLibro.setAutor(libro.getAutor());
        existingLibro.setGenero(libro.getGenero());
        existingLibro.setFechaPublicacion(libro.getFechaPublicacion());
        return libroRepo.save(existingLibro);
    }

    public void deleteLibro(Long id) {
        if (!libroRepo.existsById(id)) {
            throw new RuntimeException("Libro con ID " + id + " no encontrado para eliminación.");
        }
        libroRepo.deleteById(id);
    }

    // Nuevo: Buscar libros por autor
    public List<Libro> findLibrosByAutor(String autor) {
        return libroRepo.findByAutor(autor); // Asegúrate de que `findByAutor` esté definido en el repositorio.
    }

    // Nuevo: Eliminar todos los libros
    public void deleteAllLibros() {
        libroRepo.deleteAll();
    }
}
