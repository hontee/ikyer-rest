package com.ikyer.master.api.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

/**
 * 主题
 * @author larry.qi
 */
@Entity
@Table(name = "T_TOPIC")
public class Topic extends AuditorObject {

	private static final long serialVersionUID = 1L;

	@Length(max = 512)
	private String tags;

	@Column(columnDefinition = "int default 0")
	private Integer stars;

	@Column(columnDefinition = "int default 0")
	private Integer stats;

	@Column(columnDefinition = "tinyint default 0")
	private Byte pick;
	
	public Topic() {
		super();
	}

	public Topic(Long id) {
		super(id);
	}

	public Topic(String title) {
		super(title);
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public Integer getStats() {
		return stats;
	}

	public void setStats(Integer stats) {
		this.stats = stats;
	}

	public Byte getPick() {
		return pick;
	}

	public void setPick(Byte pick) {
		this.pick = pick;
	}

}
