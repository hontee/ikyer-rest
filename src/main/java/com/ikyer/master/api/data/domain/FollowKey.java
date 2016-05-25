package com.ikyer.master.api.data.domain;

import java.io.Serializable;

/**
 * 关注实体类通用的联合主键，该对象必须实现 {@link Serializable} 接口
 * 
 * <li>oid: 对象ID</li>
 * <li>fid: 关注对象ID</li>
 * @author larry.qi
 */
public class FollowKey implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long oid;
	private Long fid;
	
	public FollowKey(Long oid, Long fid) {
		this.oid = oid;
		this.fid = fid;
	}

	public FollowKey() {
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

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
