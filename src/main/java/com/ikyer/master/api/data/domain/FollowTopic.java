package com.ikyer.master.api.data.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 关注主题
 * @author larry.qi
 */
@Entity
@Table(name = "T_FOLLOW_TOPIC")
@IdClass(FollowKey.class)
public class FollowTopic extends FollowObject {

	private static final long serialVersionUID = 1L;

	@Id
	private Long oid;

	@Id
	private Long fid;
	
	/**
	 * 用户关注的主题
	 */
	@ManyToOne
	@JoinColumn(name = "fid", insertable = false, updatable = false)
	private Topic topic;
	
	/**
	 * 用户
	 */
	@ManyToOne
	@JoinColumn(name = "oid", insertable = false, updatable = false)
	private User user;
	
	public FollowTopic(Long oid, Long fid) {
		super();
		this.oid = oid;
		this.fid = fid;
	}

	public FollowTopic() {
		super();
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
