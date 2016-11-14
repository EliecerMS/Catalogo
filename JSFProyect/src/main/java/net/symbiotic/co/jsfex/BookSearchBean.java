package net.symbiotic.co.jsfex;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.symbiotic.co.dao.BookDAO;
//import net.symbiotic.co.entity.User;

@ManagedBean
@SessionScoped
public class BookSearchBean {
	
	private String autor;
	
	@EJB
    BookDAO userDao;
 
    
    @PostConstruct
    public void init(){
    	
    	
    }

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
