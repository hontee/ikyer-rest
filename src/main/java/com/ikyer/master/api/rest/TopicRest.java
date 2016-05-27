package com.ikyer.master.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikyer.master.api.data.domain.Topic;
import com.ikyer.master.api.service.TopicService;

@RestController
@Scope("prototype")
@RequestMapping("api/topics")
public class TopicRest {
	
	@Autowired
	private TopicService topicS;
	
	@RequestMapping("{id}")
	public ResponseEntity<Topic> findById(@PathVariable Long id) throws Exception {
		Topic topic = topicS.findOne(id);
		return new ResponseEntity<Topic>(topic, HttpStatus.OK);
	}

}
