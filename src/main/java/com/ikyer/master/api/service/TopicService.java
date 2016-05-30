package com.ikyer.master.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ikyer.master.api.data.domain.FollowKey;
import com.ikyer.master.api.data.domain.Topic;
import com.ikyer.master.api.data.form.TopicForm;
import com.ikyer.master.api.data.query.TopicQuery;
import com.ikyer.master.api.exceptions.CoreException;

public interface TopicService {
	
	Topic findOne(Long id);
	
	Topic add(TopicForm form);
	
	void addTP(FollowKey fk);
	
	void statAll();

	void delete(Long id) throws CoreException;
	
	void deleteTP(FollowKey fk);
	
	Page<Topic> findAll(TopicQuery q, Pageable pageable) throws CoreException;
	
	Page<Topic> findAll(Long uid, Pageable pageable) throws CoreException;
	
	Topic update(Long id, TopicForm form) throws CoreException;
	
	void pick(Long id);
	
	void unpick(Long id);
	
	void follow(Long fid);
	
	void unfollow(Long fid);
}
