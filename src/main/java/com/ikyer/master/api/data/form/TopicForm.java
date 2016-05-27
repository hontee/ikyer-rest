package com.ikyer.master.api.data.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class TopicForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String title;

	@NotNull
	private String description;

	@NotNull
	private String tags;

	private Byte state = 1;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

}
