package com.ikyer.master.api.data.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 * 用户登录，注册授权
 * @author larry.qi
 */
public class AuthForm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Length(min = 6, max = 16)
	private String username;
	
	@Email
	@NotNull
	private String email;
	
	@NotNull
	@Length(min = 6, max = 16)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
