package net.symbiotic.co.dao;


import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;

import com.datastax.driver.core.Row;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;

import net.symbiotic.co.db.DBClientHelper;
import net.symbiotic.co.db.DBConstants;
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

	/**
	 * Empty constructor.
	 */
	public UserDAO() { }

	@PostConstruct
	public void setUp() {
		userMapper = new MappingManager(cClient.getSession()).mapper(User.class);
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
		Row row = cClient.getSession().execute(
				"SELECT * FROM " + DBConstants.TABLE_USERS + " WHERE name = '"+name+"'"
				).one();
		return new User(row.getUUID(0),row.getString(1), row.getString(2), row.getString(3));
	}

}