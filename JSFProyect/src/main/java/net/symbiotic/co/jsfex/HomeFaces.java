package net.symbiotic.co.jsfex;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import net.symbiotic.co.dao.BookDAO;
import net.symbiotic.co.entity.Book;


@ManagedBean
@RequestScoped

public class HomeFaces {

	@EJB
	BookDAO bookDAO;
	private List<Book> bookList;
	@PostConstruct 
	private void init(){
		VerTodos();
	}
	
	public void VerTodos(){
		this.bookList = bookDAO.findAll();
	}

	public List<Book> getBookList() {
		return bookList;
	}
	
	
}
