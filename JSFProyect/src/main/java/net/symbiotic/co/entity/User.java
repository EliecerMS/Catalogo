package net.symbiotic.co.entity;

import java.util.UUID;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import net.symbiotic.co.db.DBConstants;

@Table(name = DBConstants.TABLE_USERS, keyspace = DBConstants.KEYSPACE)
public class User {

	@PartitionKey
	@Column(name = "user_id")
	private UUID userId;
	
	@Column
	private String email;
	
	@Column
	private String name;
	
	@Column
	private String password;
	
	public User(){
		
	}
	
	public User(UUID userId, String email, String name, String password) {
		this.userId = userId;
		this.email = email;
		this.name = name;
		this.password = password;
	}



	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
