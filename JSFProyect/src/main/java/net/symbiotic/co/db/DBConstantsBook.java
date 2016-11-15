package net.symbiotic.co.db;

public final class DBConstantsBook {
	private DBConstantsBook(){	
	}
	public static final String TABLE_USERS = "libro";
	public static final String KEYSPACE = "k_co";
	
	public static String[] getContactPoints() {
		return new String[] { "127.0.0.1" };
	}

}
