package com.ikyer.master.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.ikyer.master.api.data.domain.Topic;
import com.ikyer.master.api.data.form.TopicForm;
import com.ikyer.master.api.data.repository.TopicRepository;
import com.ikyer.master.api.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicRepository topicR;
	
	@Override
	public Topic findOne(Long id) {
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

}
