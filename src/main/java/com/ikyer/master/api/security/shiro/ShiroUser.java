package com.ikyer.master.api.security.shiro;

import java.io.Serializable;

public class ShiroUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String username;
	private String password;
	private String salt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
