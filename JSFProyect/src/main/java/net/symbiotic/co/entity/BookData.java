package net.symbiotic.co.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "BookData", eager = true)
@SessionScoped 

public class BookData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String autor;
	private String isbn;
	private String anio;
	private String description;
	private String editorial;
	private String nombre;
	private String precio;
	private String tema;


		private static final ArrayList<Book> libros 
		= new ArrayList<Book>(Arrays.asList(
		new Book("eklnh","hola", "jg", "fkfk", "ddfsj", "snjfd", 1234, "ho")));
		
		
		public ArrayList<Book> getLibros(){
			return libros;
		}

		public String getAutor() {
			return autor;
		}

		public void setAutor(String autor) {
			this.autor = autor;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
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

		public String getPrecio() {
			return precio;
		}

		public void setPrecio(String precio) {
			this.precio = precio;
		}

		public String getTema() {
			return tema;
		}

		public void setTema(String tema) {
			this.tema = tema;
		}
		
		
}
