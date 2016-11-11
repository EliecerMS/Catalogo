package net.symbiotic.co.db;


import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.exceptions.InvalidQueryException;
import com.datastax.driver.core.exceptions.NoHostAvailableException;
import com.datastax.driver.core.policies.ConstantReconnectionPolicy;
import com.datastax.driver.core.policies.DowngradingConsistencyRetryPolicy;

/**
 * Class used for connect with a Cassandra Session in the cluster.
 * Used for a single keyspace. Instance only one for keyspace.
 * @author csanchezbar
 * @since 30/07/2015
 * @version 1.0
 */
class CassandraClientHelper {

	/**
	 * The Cassandra Session.
	 */
	private Session cassandraSession;
	/**
	 * The Keyspace to connect.
	 */
	private String keyspace;
	/**
	 * The list of nodes ip's.
	 */
	private String[] nodes;
	
	/**
	 * Connect with Cassandra cluster.
	 * Construct with the metadata in the CassandraDB 
	 * annotation in the caller class.
	 * @param keyspaceName the Keyspace name
	 * @param nodesList the list of contact points
	 */
	CassandraClientHelper(final String keyspaceName, final String[] nodesList) {
		 keyspace = keyspaceName;
		 nodes = nodesList.clone();
	}

	/**
	 * Create a connection and session with a keyspace name and nodes hosts.
	 * If throw a exception  the cassandraSession instance is set to null.
	 * @return Session the Session created
	 */
	public final Session connect() {
		try {
			Cluster cassandraCluster = Cluster.builder().addContactPoints(nodes)
					//.withCredentials("cassandra", "cassandra")
					.withRetryPolicy(DowngradingConsistencyRetryPolicy.INSTANCE)
				    .withReconnectionPolicy(new ConstantReconnectionPolicy(100L)).build();
			cassandraSession = cassandraCluster.connect(keyspace);	
		} catch (NoHostAvailableException | IllegalStateException | InvalidQueryException e) {
			cassandraSession = null;
			System.err.println("Can not connect to cassandra cluster: {}" + e.getMessage());
	    }  
	    return cassandraSession;
	}
	
	/**
	 * Close the Cassandra Session.
	 */
	public final void closeConnection() {
		if (isConnect()) {
			cassandraSession.close();
		}
	}
	  
	/**
	 * Get the Cassandra Session.
	 * @return the Cassandra Session.
	 */
	public final Session getSession() {
		return cassandraSession;
	}
	  
	/**
	 * The actual Session is connected and not null.
	 * @return true is the Session is not null.
	 */
	public final boolean isConnect() {
		return null != cassandraSession && !cassandraSession.isClosed();
	}
	
	/**
	 * Log the Metadata of a cluster info.
	 * @return String Cassandra cluster Metadata
	 */
	public final String metadataClusterInfo() {
		Metadata metadata = cassandraSession.getCluster().getMetadata();
		if (null != metadata) {
			StringBuffer bufString = new StringBuffer("Connected to cluster:" 
											+ metadata.getClusterName());
		        
			for (Host host : metadata.getAllHosts()) {
				bufString.append("\nDatatacenter: " + host.getDatacenter() 
		                   + "- Host: " + host.getAddress() 
		                   + "- Rack: " + host.getRack());
			}
			return bufString.toString();
		} else {
			return null;
		}
	}
}
