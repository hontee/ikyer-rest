package com.ikyer.master.api.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ikyer.master.api.data.domain.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long>,
	JpaSpecificationExecutor<Topic> {
	
	/**
	 * 精选
	 * @param id
	 * @return
	 */
	@Modifying
	@Query("update Topic t set t.pick = 1 where t.id = :id")
	int pick(@Param("id") Long id);
	
	/**
	 * 取消精选
	 * @param id
	 * @return
	 */
	@Modifying
	@Query("update Topic t set t.pick = 0 where t.id = :id")
	int unpick(@Param("id") Long id);
	
	/**
	 * 统计产品关注数
	 * @return
	 */
	@Modifying
	@Query(value = "update t_topic t set t.stats=(select count(1) from t_follow_tp tp where tp.tid = t.id),"
			+ "t.stars=(select count(1) from t_follow_topic ft where ft.fid = t.id)", nativeQuery = true)
	int statAll(); 

	/**
	 * 统计某个产品的关注数
	 * @param id
	 * @return
	 */
	@Modifying
	@Query(value = "update t_topic t set t.stats=(select count(1) from t_follow_tp tp where tp.tid = t.id),"
			+ "t.stars=(select count(1) from t_follow_topic ft where ft.fid = t.id) where t.id = :id", nativeQuery = true)
	int statOne(@Param("id") Long id); 
	
}
