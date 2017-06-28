package cn.mldn.microboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.mldn.microboot.service.IMessageService;
import cn.mldn.microboot.service.impl.MessageServiceImpl;

@Configuration
public class ServiceConfig {
	
	@Bean
	public IMessageService getMessageService() {
		return new MessageServiceImpl(); 
	}
}
