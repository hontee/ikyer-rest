package com.ikyer.master.mvc.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ikyer.master.api.service.TopicService;

@Controller
@Scope("prototype")
@RequestMapping("topics")
public class TopicController {
	
	private Logger logger = LoggerFactory.getLogger(TopicController.class);
	
	@Autowired
	private TopicService topicS;

	@RequestMapping
	public String user(Model model) {
		return "topic/index";
	}
	
	@RequestMapping("newest")
	public String newest(Model model) {
		return "topic/index";
	}
	
	@RequestMapping("hot")
	public String hot(Model model) {
		return "topic/index";
	}
	
	@RequestMapping("pick")
	public String pick(Model model) {
		return "topic/index";
	}
	
	@RequestMapping("{id}")
	public String tp(@PathVariable Long id, Model model) {
		return "topic/tp";
	}
	
	@RequestMapping("new")
	public String addTopic(Model model) {
		return "topic/new";
	}
}
