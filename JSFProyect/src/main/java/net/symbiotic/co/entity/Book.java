package net.symbiotic.co.entity;

import com.datastax.driver.mapping.annotations.ClusteringColumn;

//import java.util.UUID;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import net.symbiotic.co.db.DBConstants;

@Table(name = DBConstants.TABLE_BOOK, keyspace = DBConstants.KEYSPACE)
public class Book {

	@PartitionKey
	@Column(name = "autor")
	private String autor;
	
	@ClusteringColumn
	private String isbn;
	
	@Column
	private String anio;
	
	@Column
	private String description;
	
	@Column
	private String editorial;
	
	@Column
	private String nombre;
	
	@Column
	private double precio;
	
	@Column
	private String tema;
	
	public Book(){
		
	}
	
	public Book(String autor, String isbn, String anio, String description, String editorial, String nombre, double precio, String tema) {
		this.autor = autor;
		this.isbn = isbn;
		this.anio = anio;
		this.description = description;
		this.editorial = editorial;
		this.nombre= nombre;
		this.precio = precio;
		this.tema = tema;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	
}
	
