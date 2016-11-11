package net.symbiotic.co.jsfex;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.symbiotic.co.dao.UserDAO;
import net.symbiotic.co.entity.User;
 

@ManagedBean
@SessionScoped
public class UserBean {
 
    private String name;
    private User user;
   
    @EJB
    UserDAO userDao;
 
    
    @PostConstruct
    public void init(){
    	
    	
    }
    
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
    
    public User getUser(String name){
    	return userDao.findByName(name);
    }

 
    

}