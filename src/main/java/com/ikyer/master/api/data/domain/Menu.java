package com.ikyer.master.api.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * 系统菜单设置
 * @author larry.qi
 */
@Entity
@Table(name = "T_MENU")
public class Menu extends AuditorObject {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Length(max = 128)
	@Column(unique = true)
	private String path;
	
	public Menu() {
		super();
	}

	public Menu(Long id) {
		super(id);
	}

	public Menu(String title) {
		super(title);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
