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

		public Capitulo() {
		}

		public Capitulo(long id, String nombre, int numero, int paginas, Libro libro) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.numero = numero;
			this.paginas = paginas;
			this.libro = libro;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}

		public int getPaginas() {
			return paginas;
		}

		public void setPaginas(int paginas) {
			this.paginas = paginas;
		}

		public Libro getLibro() {
			return libro;
		}

		public void setLibro(Libro libro) {
			this.libro = libro;
		}
	    
	    
		
	    
}
