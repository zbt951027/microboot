package cn.mldn.microboot.controller.util;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;

public class AbstractBaseController {
	@Resource
	private MessageSource messageResource;
	
	public String getMessage(String key, Object... args) {
		return this.messageResource.getMessage(key, args, Locale.getDefault());
	}
}
