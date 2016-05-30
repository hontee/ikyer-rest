package com.ikyer.master.mvc.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ikyer.master.api.service.ProductService;
import com.ikyer.master.api.service.TopicService;

@Component
public class TaskController {

	private Logger logger = LoggerFactory.getLogger(TaskController.class);
	private SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private TopicService topicS;
	
	@Autowired
	private ProductService productS;
	
	/**
	 * 每天凌晨4点执行任务
	 */
	@Scheduled(cron = "0 0 04 * * ?")
	public void rebuildStats() {
		logger.info("开始执行自定义统计任务：{}", fmt.format(new Date()));
		try {
			productS.statAll();
			topicS.statAll();
		} catch (Exception e) {
			logger.error("执行自定义任务出错：{}", e.getMessage());
			e.printStackTrace();
		}
		logger.info("执行自定义统计任务结束：{}", fmt.format(new Date()));
	}
	
}
