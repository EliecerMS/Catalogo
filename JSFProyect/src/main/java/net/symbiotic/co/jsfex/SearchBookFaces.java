package net.symbiotic.co.jsfex;

//import java.util.Iterator;
//import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import net.symbiotic.co.dao.BookDAO;
import net.symbiotic.co.entity.Book;
import net.symbiotic.co.entity.User;

@ManagedBean
@RequestScoped

public class SearchBookFaces {

	@EJB
	BookDAO bookDAO;
	private List<Book> bookList;
	private List<Book> bookResult;
	private List<Book> bookFiltrado;

	//	private Iterator<Book> it= bookList.iterator();
	private String name;
	private String message;
//	private Book selectedBook;
	
	@PostConstruct 
	private void init(){
		VerTodos();
	}
	
	public List<Book> getBookList(){
		return bookList;
	}

	public List<Book> getBookResult() {
		return bookResult;
	}
	

	public List<Book> getBookFiltrado() {
		return bookFiltrado;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void VerResult(){
		if(bookDAO.findByName(name)==null){
			this.message = "No se han encontrado resultados";
		}
		else{
			this.bookResult = bookDAO.findByName(name);
			this.message = "";
		}
		
    }
	
	public void VerTodos(){
		this.bookList = bookDAO.findAll();
	}
	
	public String NombreLibro(){
		
		for( Book s : this.bookList ){
			if (s.getNombre().contains(name)) {
				return s.getNombre().toString();
			}
//			if (s.getDescription().contains(name)) {
//				this.bookFiltrado.add(s);
//				break;
//			}
//			if (s.getAutor().contains(name)) {
//				this.bookFiltrado.add(s);
//				break;
//			}
//			if (s.getEditorial().contains(name)) {
//				this.bookFiltrado.add(s);
//				break;
//			}
//			if (s.getImagen().contains(name)) {
//				this.bookFiltrado.add(s);
//				break;
//			}
//			if (s.getIsbn().contains(name)) {
//				this.bookFiltrado.add(s);
//				break;
//			}
//			if (s.getParsePrecio().contains(name)) {
//				this.bookFiltrado.add(s);
//				break;
//			}
		}
		return message;
	}
	
	public Book FindByPK(String autor, String isbn){
		return bookDAO.findByPK(autor, isbn);
	}
}
