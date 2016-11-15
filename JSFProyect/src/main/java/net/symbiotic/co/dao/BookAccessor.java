package net.symbiotic.co.dao;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Query;
import com.datastax.driver.mapping.annotations.Accessor;

import net.symbiotic.co.db.DBConstants;
import net.symbiotic.co.entity.Book;

@Accessor
interface BookAccessor {

	@Query("SELECT * FROM " + DBConstants.TABLE_BOOK)
	Result<Book> findAll();
	
//	@Query("SELECT * FROM " + DBConstants.TABLE_BOOK + " WHERE name = ? LIMIT 1")
//	@Query("SELECT * FROM " + DBConstants.TABLE_BOOK + " WHERE name = ? LIMIT 1")
//	Book findByAutor(String autor);
	

}
