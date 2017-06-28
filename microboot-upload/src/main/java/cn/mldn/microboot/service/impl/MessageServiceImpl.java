package cn.mldn.microboot.service.impl;

import cn.mldn.microboot.service.IMessageService;

public class MessageServiceImpl implements IMessageService {
	@Override
	public String info() {
		return "www.mldn.cn";
	}
}
