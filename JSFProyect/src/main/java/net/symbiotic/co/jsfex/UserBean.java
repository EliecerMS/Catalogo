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
    private String user_id;
   
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
    
    public void getUser(){
    	User u = userDao.findByName(name);
    	this.user_id =  u.getUserId().toString();
    }

	public String getUser_id() {
		return user_id;
	}
    
    
    

}