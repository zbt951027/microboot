package cn.mldn.microboot.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.mldn.microboot.Application;
import cn.mldn.microboot.service.IDeptService;

@SpringBootTest(classes=Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestDeptService {
	@Resource
	private IDeptService deptService;
	
	@Test
	public void testList() throws Exception {
		System.err.println(deptService.list()); 
	}
}
