package net.symbiotic.co.dao;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;

import net.symbiotic.co.db.DBConstants;
import net.symbiotic.co.entity.User;

@Accessor
interface UserAccessor {
	
	@Query("SELECT * FROM " + DBConstants.TABLE_USERS)
	Result<User> findAll();
	
	@Query("SELECT * FROM " + DBConstants.TABLE_USERS + " WHERE name = ? 1")
	User findByName(String name);
	
	
}
