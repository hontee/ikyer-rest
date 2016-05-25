package com.ikyer.master.api.data.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 关注实体基类，自动添加关注时间
 * @author larry.qi
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class FollowObject implements Serializable {

	private static final long serialVersionUID = 1L;

	@CreatedDate
	private Date ftime;

	public Date getFtime() {
		return ftime;
	}

	public void setFtime(Date ftime) {
		this.ftime = ftime;
	}

}
