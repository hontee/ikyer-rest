package com.ikyer.master.client;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ikyer.master.api.auto.client.EmailClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailSenderTests {

	@Autowired
	private EmailClient client;
	
	@Test
	public void sendEmailTest() throws MessagingException {
		client.sendText("测试", "Test Email sender.", "honty77@qq.com");
	}
}
