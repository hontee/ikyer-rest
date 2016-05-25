package com.ikyer.master.api.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ikyer.master.api.data.domain.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long>,
	JpaSpecificationExecutor<Topic> {
	
}
