package net.symbiotic.co.jsfex;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "navigationcontroller", eager=true)
@RequestScoped
public class NavigationController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String moveToPageBookInformation(){
		return "BookInformation";
	}

}
