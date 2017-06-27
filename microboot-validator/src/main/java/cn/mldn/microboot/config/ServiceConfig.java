package cn.mldn.microboot.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import cn.mldn.microboot.service.IMessageService;
import cn.mldn.microboot.service.impl.MessageServiceImpl;

@Configuration
public class ServiceConfig {

	@Bean
	public IMessageService getMessageService() {
		return new MessageServiceImpl();
	}

//	@Bean
//	public EmbeddedServletContainerCustomizer containerCustomizer() {
//		return new EmbeddedServletContainerCustomizer() {
//			@Override
//			public void customize(ConfigurableEmbeddedServletContainer container) {
//				ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND, "/pages/error-404.html");
//				ErrorPage error400 = new ErrorPage(HttpStatus.BAD_REQUEST, "/pages/error-400.html");
//				ErrorPage error500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/pages/error-500.html");
//				container.addErrorPages(error400, error404, error500);
//			}
//		};
//	} 
}
