package net.symbiotic.co.jsfex;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import net.symbiotic.co.dao.BookDAO;

@ManagedBean
@RequestScoped

public class BookInformationFaces {

	@EJB
	BookDAO bookDAO;
	
	@PostConstruct 
	private void init(){
		
	}
}
