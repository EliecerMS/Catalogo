package net.symbiotic.co.db;

public final class DBConstants {
	private DBConstants() {
	}
	public static final String TABLE_USERS = "users";
	public static final String TABLE_BOOK = "libro";
	public static final String KEYSPACE = "k_co";
	
	public static String[] getContactPoints() {
		return new String[] { "127.0.0.1" };
	}
}
