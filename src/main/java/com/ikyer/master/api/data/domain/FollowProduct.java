package com.ikyer.master.api.data.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 关注产品
 * @author larry.qi
 */
@Entity
@Table(name = "T_FOLLOW_PRODUCT")
@IdClass(FollowKey.class)
public class FollowProduct extends FollowObject{

	private static final long serialVersionUID = 1L;

	@Id
	private Long oid;

	@Id
	private Long fid;
	
	/**
	 * 用户关注的产品
	 */
	@ManyToOne
	@JoinColumn(name = "fid", insertable = false, updatable = false)
	private Product product;
	
	/**
	 * 用户
	 */
	@ManyToOne
	@JoinColumn(name = "oid", insertable = false, updatable = false)
	private User user;
	
	public FollowProduct(Long oid, Long fid) {
		super();
		this.oid = oid;
		this.fid = fid;
	}

	public FollowProduct() {
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
