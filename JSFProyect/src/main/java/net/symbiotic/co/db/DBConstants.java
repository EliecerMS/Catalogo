package net.symbiotic.co.db;

public final class DBConstants {
	private DBConstants() {
	}
	public static final String TABLE_USERS = "users";
	public static final String KEYSPACE = "keyspace";
	
	public static String[] getContactPoints() {
		return new String[] { "127.0.0.1" };
	}
}
