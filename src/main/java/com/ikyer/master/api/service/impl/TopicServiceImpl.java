package com.ikyer.master.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikyer.master.api.data.domain.Topic;
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

}
