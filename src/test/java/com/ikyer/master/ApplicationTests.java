package com.ikyer.master;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.ikyer.master.api.data.domain.Topic;
import com.ikyer.master.api.data.repository.TopicRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	
	@Autowired
	private TopicRepository topicR;

	@Test
	public void contextLoads() {
		List<Topic> list = topicR.findAll();
		System.out.println(JSON.toJSONString(list, true));
	}

}
