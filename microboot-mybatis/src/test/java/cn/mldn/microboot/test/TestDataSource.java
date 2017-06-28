package cn.mldn.microboot.test;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.mldn.microboot.Application;

@SpringBootTest(classes=Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestDataSource {
	@Resource
	private DataSource datasource;
	
	@Test
	public void testConnection() throws Exception {
		System.err.println(this.datasource.getConnection());
	} 
}
