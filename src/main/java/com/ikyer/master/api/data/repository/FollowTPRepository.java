package com.ikyer.master.api.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikyer.master.api.data.domain.FollowKey;
import com.ikyer.master.api.data.domain.FollowTP;

@Repository
public interface FollowTPRepository extends JpaRepository<FollowTP, FollowKey> {

	/**
	 * 产品所属的主题
	 * @param fid
	 * @param pageable
	 * @return
	 */
	Page<FollowTP> findByFid(Long fid, Pageable pageable);
	
	/**
	 * 产品关联的主题
	 * @param oid
	 * @param pageable
	 * @return
	 */
	Page<FollowTP> findByOid(Long oid, Pageable pageable);
	
}
