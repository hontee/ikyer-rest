package com.ikyer.master.api.data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ikyer.master.api.data.domain.FollowKey;
import com.ikyer.master.api.data.domain.FollowTopic;

@Repository
public interface FollowTopicRepository extends JpaRepository<FollowTopic, FollowKey> {

	/**
	 * 关注主题的用户列表
	 * @param Fid
	 * @param pageable
	 * @return
	 */
	Page<FollowTopic> findByFid(Long Fid, Pageable pageable);
	
	/**
	 * 用户关注的主题列表
	 * @param oid
	 * @param pageable
	 * @return
	 */
	Page<FollowTopic> findByOid(Long oid, Pageable pageable);
	
	/**
	 * 用户关注的主题IDs, 用于判断是否关注主题
	 * @param oid 用户ID
	 * @return
	 */
	@Query("select fid from FollowTopic fp where fp.oid = :oid")
	List<Long> findFids(@Param("oid") Long oid);
	
}
