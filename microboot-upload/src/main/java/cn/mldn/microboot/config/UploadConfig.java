package cn.mldn.microboot.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UploadConfig {
	
	@Bean
	public MultipartConfigElement getMultipartConfig() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize("10MB");
		factory.setMaxRequestSize("20MB");
		factory.setLocation("/");
		return factory.createMultipartConfig();
	}
}
