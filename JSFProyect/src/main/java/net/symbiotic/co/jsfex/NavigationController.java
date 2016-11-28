package net.symbiotic.co.jsfex;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "navigationcontroller", eager=true)
@RequestScoped
public class NavigationController implements Serializable{
	public String moveToPageBookInformation(){
		return "BookInformation";
	}

}
