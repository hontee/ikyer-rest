package com.ikyer.master.test.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.ikyer.master.api.data.domain.FollowTopic;
import com.ikyer.master.api.data.repository.FollowTopicRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FollowTopicRepositoryTests {

	@Autowired
	private FollowTopicRepository repository;
	
	@Test
	public void test() {
		List<FollowTopic> list = repository.findAll();
		System.out.println(JSON.toJSONString(list, true));
	}
}
