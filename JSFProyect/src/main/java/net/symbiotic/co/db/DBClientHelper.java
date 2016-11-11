package net.symbiotic.co.db;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.datastax.driver.core.Session;

/**
 * Singleton for Cassandra Client Helper.
 * Maintain a single instance of Cassandra session in keyspace.
 * Manage a pool of connections for keyspace
 * @author csanchezbar
 * @since 27/07/2015
 * @version 1.0
 */
@Startup
@Singleton
public class DBClientHelper {

	/**
	 * CassandraClientHelper class.
	 */
	private CassandraClientHelper cClient;
	
	/**
	 * Init CassandraClient, and connect to the cluster.
	 */
	@PostConstruct
	public void setUp() {
		cClient = new CassandraClientHelper(DBConstants.KEYSPACE, DBConstants.getContactPoints());
            
  	   if (null != cClient.connect()) {  
	  	   System.out.println(cClient.metadataClusterInfo());
  	   } 
	}
	
	/**
	 * Get the Cassandra Session.
	 * @return the Cassandra Session.
	 */
	public Session getSession() {
		return cClient.getSession();
	}
	
	/**
	 * If in the actual session is already connected and not null.
	 * @return true if is connected with the in the actual session
	 */
	public boolean isConnect() {
		return cClient.isConnect();
	}
	
	/**
	 * Close the connection of a CassandraClient session.
	 */
	@PreDestroy
	public void closeConnection() {
	    cClient.closeConnection();
	}
}
