package com.ikyer.master.api.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

/**
 * 产品信息
 * @author larry.qi
 */
@Entity
@Table(name = "T_PRODUCT")
public class Product extends AuditorObject {

	private static final long serialVersionUID = 1L;

	@URL
	@NotNull
	@Length(max = 1024)
	private String url;

	@NotNull
	@Length(max = 512)
	private String tags;

	@Length(max = 128)
	private String reffer;

	@Column(columnDefinition = "int default 0")
	private Integer stars;

	@Column(columnDefinition = "int default 0")
	private Integer hit;

	@Column(columnDefinition = "tinyint default 0")
	private Byte pick;
	
	public Product() {
		super();
	}

	public Product(Long id) {
		super(id);
	}

	public Product(String title) {
		super(title);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getReffer() {
		return reffer;
	}

	public void setReffer(String reffer) {
		this.reffer = reffer;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public Integer getHit() {
		return hit;
	}

	public void setHit(Integer hit) {
		this.hit = hit;
	}

	public Byte getPick() {
		return pick;
	}

	public void setPick(Byte pick) {
		this.pick = pick;
	}

}
