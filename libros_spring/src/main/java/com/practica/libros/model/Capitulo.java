package com.practica.libros.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Capitulo {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    @Column
	    private String nombre;

	    @Column
	    private int numero;

	    @Column
	    private int paginas;

	    @ManyToOne
	    @JoinColumn(name = "libro_id", nullable = false)
	    private Libro libro;
}
