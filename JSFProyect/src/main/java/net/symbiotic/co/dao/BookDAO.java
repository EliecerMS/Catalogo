package net.symbiotic.co.dao;

import java.util.List;
//import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;

import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;

import net.symbiotic.co.db.DBClientHelper;
import net.symbiotic.co.entity.Book;

@Singleton
public class BookDAO {

	/**
	 * The DBClientHelper for User Keyspace.
	 */
	@EJB
	private DBClientHelper cClient;

	/**
	 * Mapper Class for the UserLX Entity.
	 */
	private Mapper<Book> BookMapper;
	private BookAccessor BookAccessor;
	/**
	 * Empty constructor.
	 */
	public BookDAO() { }

	@PostConstruct
	public void setUp() {
		BookMapper = new MappingManager(cClient.getSession()).mapper(Book.class);
		BookAccessor = new MappingManager(cClient.getSession()).createAccessor(BookAccessor.class);
		
	}

	public void save(final Book libro) {
		BookMapper.save(libro);
		
	}
	
	public Book get(final String userId){
		return BookMapper.get(userId);
	}

	public void delete(final Book theUser){
		BookMapper.delete(theUser);
	}
	
	public Book findByAutor(final String autor){
		return BookAccessor.findByAutor(autor);
	}
	
	public List<Book> findAll(){
		return BookAccessor.findAll().all();
	}

}
