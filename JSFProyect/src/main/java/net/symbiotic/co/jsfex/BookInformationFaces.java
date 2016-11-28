package net.symbiotic.co.jsfex;


import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import net.symbiotic.co.dao.BookDAO;
import net.symbiotic.co.entity.Book;

@ManagedBean(name = "bookInformation", eager = true)
@RequestScoped
@ViewScoped
public class BookInformationFaces {

	@EJB
	BookDAO bookDAO;
	
	
	Book libro;
	
	
	@PostConstruct 
	public void init(){
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String autor = params.get("bookautor");
		String isbn = params.get("bookisbn");
		libro = bookDAO.findByPK(autor, isbn);
	}


	public Book getLibro() {
		return libro;
	}

	public void setLibro(Book libro) {
		this.libro = libro;
	}	
	
	
}
