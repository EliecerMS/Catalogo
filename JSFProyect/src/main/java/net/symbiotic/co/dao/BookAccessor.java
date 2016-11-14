package net.symbiotic.co.dao;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Query;

import net.symbiotic.co.db.DBConstantsBook;
import net.symbiotic.co.entity.Book;

interface BookAccessor {

	@Query("SELECT * FROM " + DBConstantsBook.TABLE_USERS)
	Result<Book> findAll();
	
	@Query("SELECT * FROM " + DBConstantsBook.TABLE_USERS + " WHERE name = ? 1")
	Book findByName(String name);

}
