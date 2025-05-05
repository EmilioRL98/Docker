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

import com.practica.libros.model.Capitulo;
import com.practica.libros.repo.CapituloRepo;
import com.practica.libros.servicios.AutoIncrementCapituloService;


@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://frontend:80"}) // Permite solicitudes desde Angular
public class ApiCapitulosAngularController {

	@Autowired
	private CapituloRepo capituloRepo;
	
	@Autowired
    private AutoIncrementCapituloService autoIncrementService; // Inyección de AutoIncrementService para actualizar id despues de cada modificacion

  

    @GetMapping(value = "/capitulos")
    public List<Capitulo> getCapitulo() {
        return capituloRepo.findAll();
    }
    
    @GetMapping("/capitulos/{id}")
    public Capitulo getCapitulo(@PathVariable long id) {
        return capituloRepo.findById(id).orElseThrow(() -> new RuntimeException("Capitulo no encontrado"));
    }

    @PostMapping(value = "/capitulos/guardar")
    public String saveCapitulo(@RequestBody Capitulo capitulo) {
        capituloRepo.save(capitulo);
        return "Capitulo añadido";
    }

    @PutMapping(value = "/capitulos/actualizar/{id}")
    public String updateCapitulo(@PathVariable long id, @RequestBody Capitulo capitulo) {
        Capitulo updatedCapitulo = capituloRepo.findById(id).get();
        updatedCapitulo.setNombre(capitulo.getNombre());
        updatedCapitulo.setNumero(capitulo.getNumero());
        updatedCapitulo.setPaginas(capitulo.getPaginas());
        updatedCapitulo.setLibro(capitulo.getLibro());

        capituloRepo.save(updatedCapitulo);

        return "Capitulo actualizado";
    }

    @DeleteMapping(value = "capitulos/borrar/{id}")
    public String deleteCapitulo(@PathVariable long id) {
        Capitulo capituloDeleted = capituloRepo.findById(id).get();
        capituloRepo.delete(capituloDeleted);

        autoIncrementService.ajustarAutoIncrement();

        return "Capitulo eliminado";
    }
	
}
