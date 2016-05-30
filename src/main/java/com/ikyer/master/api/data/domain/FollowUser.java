package com.ikyer.master.api.data.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 关注用户
 * @author larry.qi
 */
@Entity
@Table(name = "T_FOLLOW_USER")
@IdClass(FollowKey.class)
public class FollowUser extends FollowObject {

	private static final long serialVersionUID = 1L;

	@Id
	private Long oid;

	@Id
	private Long fid;
	
	/**
	 * 关注 [我关注的用户]
	 */
	@ManyToOne
	@JoinColumn(name = "fid", insertable = false, updatable = false)
	private User follower;
	
	/**
	 * 我 [指用户自身]
	 */
	@ManyToOne
	@JoinColumn(name = "oid", insertable = false, updatable = false)
	private User user;
	
	public FollowUser(Long oid, Long fid) {
		super();
		this.oid = oid;
		this.fid = fid;
	}

	public FollowUser() {
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

	public User getFollower() {
		return follower;
	}

	public void setFollower(User follower) {
		this.follower = follower;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
