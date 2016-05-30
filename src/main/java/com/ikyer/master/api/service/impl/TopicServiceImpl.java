package com.ikyer.master.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.ikyer.master.api.data.domain.FollowKey;
import com.ikyer.master.api.data.domain.Topic;
import com.ikyer.master.api.data.form.TopicForm;
import com.ikyer.master.api.data.query.TopicQuery;
import com.ikyer.master.api.data.repository.TopicRepository;
import com.ikyer.master.api.exceptions.CoreException;
import com.ikyer.master.api.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {
	
	private Logger logger = LoggerFactory.getLogger(TopicService.class);

	@Autowired
	private TopicRepository topicR;
	
	@Override
	public Topic findOne(Long id) {
		logger.info("{}", id);
		return topicR.findOne(id);
	}

	@Override
	public Topic add(TopicForm form) {
		Preconditions.checkNotNull(form, "主题对象不能为空");
		Topic entity = new Topic();
		entity.setDescription(form.getDescription());
		entity.setState(form.getState());
		entity.setTags(form.getTags());
		entity.setTitle(form.getTitle());
		entity.setName(entity.randomUUID());
		entity.setPick((byte)0);
		entity.setStars(0);
		entity.setStats(0);
		return topicR.saveAndFlush(entity);
	}

	@Override
	public void addTP(FollowKey fk) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void statAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) throws CoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTP(FollowKey fk) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Topic> findAll(TopicQuery q, Pageable pageable) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Topic> findAll(Long uid, Pageable pageable) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Topic update(Long id, TopicForm form) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void pick(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unpick(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void follow(Long fid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unfollow(Long fid) {
		// TODO Auto-generated method stub
		
	}

}
