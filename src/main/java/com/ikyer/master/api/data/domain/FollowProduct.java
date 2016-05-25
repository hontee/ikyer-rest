package com.ikyer.master.api.data.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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

}
