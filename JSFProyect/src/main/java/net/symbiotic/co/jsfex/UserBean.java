package net.symbiotic.co.jsfex;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 

@ManagedBean
@SessionScoped
public class UserBean {
 
    private String name;
    private String autor;
   
 
    
    @PostConstruct
    public void init(){
    	
    }
    
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }

 
    

}