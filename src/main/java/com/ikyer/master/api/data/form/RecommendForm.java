package com.ikyer.master.api.data.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

public class RecommendForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@URL
	private String url;

	private String title;

	private String descripiton;

	private String keywords;

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

	public String getDescripiton() {
		return descripiton;
	}

	public void setDescripiton(String descripiton) {
		this.descripiton = descripiton;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

}
