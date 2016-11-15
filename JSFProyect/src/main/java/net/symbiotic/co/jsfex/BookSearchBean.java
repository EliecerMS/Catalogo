package net.symbiotic.co.jsfex;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.symbiotic.co.dao.BookDAO;
import net.symbiotic.co.entity.Book;

@ManagedBean
@SessionScoped
public class BookSearchBean {
	
	private String autor;
	
	@EJB
    BookDAO BookDao;
 
    
    @PostConstruct
    public void init(){
    	
    	
    }

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public void getUser(){
	Book u = BookDao.findByAutor(autor);
//	this.user_id =  u.getUserId().toString();
	}

}
