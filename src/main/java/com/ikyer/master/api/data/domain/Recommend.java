package com.ikyer.master.api.data.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

/**
 * 推荐
 * @author larry.qi
 */
@Entity
@Table(name = "T_RECOMMEND")
public class Recommend extends AuditorObject {

	private static final long serialVersionUID = 1L;

	@URL
	@NotNull
	@Length(max = 1024)
	private String url;
	
	@Length(max = 1024)
	private String keywords;

	@Length(max = 512)
	private String remark;
	
	public Recommend() {
		super();
	}

	public Recommend(Long id) {
		super(id);
	}

	public Recommend(String title) {
		super(title);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
