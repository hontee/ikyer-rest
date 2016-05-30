package com.ikyer.master.api.data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ikyer.master.api.data.domain.FollowKey;
import com.ikyer.master.api.data.domain.FollowProduct;

@Repository
public interface FollowProductRepository extends JpaRepository<FollowProduct, FollowKey> {

	/**
	 * 关注产品的用户列表
	 * @param fid
	 * @param pageable
	 * @return
	 */
	Page<FollowProduct> findByFid(Long fid, Pageable pageable);
	
	/**
	 * 用户关注的产品列表
	 * @param oid
	 * @param pageable
	 * @return
	 */
	Page<FollowProduct> findByOid(Long oid, Pageable pageable);
	
	/**
	 * 用户关注的产品IDs, 用于判断是否关注产品
	 * @param oid 用户ID
	 * @return
	 */
	@Query("select fid from FollowProduct fp where fp.oid = :oid")
	List<Long> findFids(@Param("oid") Long oid);

}