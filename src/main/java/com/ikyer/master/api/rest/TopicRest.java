package com.ikyer.master.api.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.ikyer.master.api.data.domain.Topic;
import com.ikyer.master.api.data.form.TopicForm;
import com.ikyer.master.api.rest.ext.ResponseVO;
import com.ikyer.master.api.service.TopicService;

@RestController
@Scope("prototype")
@RequestMapping("api/topics")
public class TopicRest {
	
	private Logger logger = LoggerFactory.getLogger(TopicRest.class);
	
	@Autowired
	private TopicService topicS;
	
	@RequestMapping("{id}")
	public ResponseEntity<Topic> findById(@PathVariable Long id) {
		Topic topic = topicS.findOne(id);
		return new ResponseEntity<Topic>(topic, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ResponseEntity<ResponseVO> addTopic(@Validated TopicForm form, BindingResult r) {
		logger.info("创建主题：{}", JSON.toJSONString(form));
		ResponseVO vo = new ResponseVO();
		
		if (r.hasErrors()) {
			vo.setMessage("请求参数错误");
			return new ResponseEntity<ResponseVO>(vo, HttpStatus.OK);
		}
		
		Topic entity = topicS.add(form);
		vo.setSuccess(true);
		vo.setMessage("创建主题成功");
		vo.setResult(entity);
		return new ResponseEntity<ResponseVO>(vo, HttpStatus.OK);
	}

}
