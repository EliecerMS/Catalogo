package net.symbiotic.co.dao;


import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;

import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;

import net.symbiotic.co.db.DBClientHelper;
import net.symbiotic.co.entity.User;

@Singleton
public class UserDAO {

	/**
	 * The DBClientHelper for User Keyspace.
	 */
	@EJB
	private DBClientHelper cClient;

	/**
	 * Mapper Class for the UserLX Entity.
	 */
	private Mapper<User> userMapper;
	private UserAccessor userAccessor;
	/**
	 * Empty constructor.
	 */
	public UserDAO() { }

	@PostConstruct
	public void setUp() {
		userMapper = new MappingManager(cClient.getSession()).mapper(User.class);
		userAccessor = new MappingManager(cClient.getSession()).createAccessor(UserAccessor.class);
		
	}

	public void save(final User user) {
		userMapper.save(user);
		
	}
	
	public User get(final UUID userId){
		return userMapper.get(userId);
	}

	public void delete(final User theUser){
		userMapper.delete(theUser);
	}
	
	public User findByName(String name){
		return userAccessor.findByName(name);
	}
	
	public List<User> findAll(){
		return userAccessor.findAll().all();
	}

}