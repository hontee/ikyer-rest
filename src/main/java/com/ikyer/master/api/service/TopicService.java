package com.ikyer.master.api.service;

import com.ikyer.master.api.data.domain.Topic;
import com.ikyer.master.api.data.form.TopicForm;

public interface TopicService {
	
	Topic findOne(Long id);
	
	Topic add(TopicForm form);

}
