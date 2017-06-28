package cn.mldn.microboot.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.mldn.microboot.Application;
import cn.mldn.microboot.producer.IMessageProducerService;

@SpringBootTest(classes={Application.class}) 
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestRabbitMQ {
	@Resource
	private IMessageProducerService messageProducer;
	
	@Test
	public void testSend() throws Exception {
		for(int i = 0; i < 100; i++) {
			this.messageProducer.sendMessage("mldn - " + i);
		}
	}
}
