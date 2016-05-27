package com.ikyer.master.api.data.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

public class ProductForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@URL
	@NotNull
	private String url;

	@NotNull
	private String title;

	@NotNull
	private String tags;

	@NotNull
	private String description;

	private Byte pick = 0;

	private Byte state = 1;

	private String reffer;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte getPick() {
		return pick;
	}

	public void setPick(Byte pick) {
		this.pick = pick;
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	public String getReffer() {
		return reffer;
	}

	public void setReffer(String reffer) {
		this.reffer = reffer;
	}

}
