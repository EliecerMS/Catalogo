package net.symbiotic.co.jsfex;

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
	private String name;
	
	@PostConstruct 
	private void init(){
//		bookList = bookDAO.findAll();
		name = "";
		this.VerResult();
	}
	
	public List<Book> getBookList(){
		return bookList;
	}

	public List<Book> getBookResult() {
		return bookResult;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void VerResult(){
    	this.bookResult = bookDAO.findByName(name);
    }
}
