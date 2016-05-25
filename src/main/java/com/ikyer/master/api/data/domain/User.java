package com.ikyer.master.api.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * 用户
 * @author larry.qi
 */
@Entity
@Table(name = "T_USER")
public class User extends BaseObject {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Length(max = 64)
	private String password;

	@NotNull
	@Length(max = 64)
	private String salt;

	@Column(columnDefinition = "tinyint default 1")
	private Byte type;
	
	public User() {
		super();
	}

	public User(Long id) {
		super(id);
	}

	public User(String title) {
		super(title);
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

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

}
