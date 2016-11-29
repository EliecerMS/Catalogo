package net.symbiotic.co.jsfex;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.symbiotic.co.dao.BookDAO;
import net.symbiotic.co.dao.UserDAO;
import net.symbiotic.co.entity.Book;
import net.symbiotic.co.entity.User;


	
	@ManagedBean
	@SessionScoped
	public class SaveBookFaces {
		private String name;
	    private String user_id;
	    private String autor;
	    private String isbn;
	    private String anio;
	    private String description;
	    private String editorial;
	    private String nombre;
	    private String precio;
	    private String tema;
	    private String imagen;
	    
	    @EJB
	    UserDAO userDao;
	    
	    @EJB
	    BookDAO bookDao;
	 
	    @PostConstruct
	    public void init(){
	    	
	    }
	    
	    public String getName() {
	        return name;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public void getUser(){
	    	User u = userDao.findByName(name);
	    	this.user_id =  u.getUserId().toString();
	    }

		public String getUser_id() {
			return user_id;
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

		public String getImagen() {
			return imagen;
		}

		public void setImagen(String imagen) {
			this.imagen = imagen;
		}

		public void guardar(){
	    	Book save = new Book();
	    	save.setAutor(autor);
	    	save.setIsbn(isbn);
	    	save.setAnio(anio);
	    	save.setDescription(description);
	    	save.setEditorial(editorial);
	    	save.setNombre(nombre);
	    	save.setPrecio(Double.parseDouble(precio));
	    	save.setTema(tema);
	    	save.setImagen(imagen);
	    	bookDao.save(save);
	    }
		
		
	}

