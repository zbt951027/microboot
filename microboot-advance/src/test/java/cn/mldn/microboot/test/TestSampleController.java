package cn.mldn.microboot.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.mldn.microboot.Application;
import cn.mldn.microboot.controller.SampleController;
import junit.framework.TestCase;

@SpringBootTest(classes={Application.class}) 
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestSampleController {
	@Resource
	private SampleController sampleController;
	
	@Test
	public void testHome() { 
		TestCase.assertEquals(sampleController.home(), "hello World!");
	}
}
