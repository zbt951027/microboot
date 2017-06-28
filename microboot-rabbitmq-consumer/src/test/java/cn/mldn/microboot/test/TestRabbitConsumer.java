package cn.mldn.microboot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.mldn.microboot.Application;

@SpringBootTest(classes={Application.class}) 
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestRabbitConsumer {
	@Test
	public void testConsumer() {
		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
	}
}