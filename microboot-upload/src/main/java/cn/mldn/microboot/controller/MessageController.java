package cn.mldn.microboot.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.mldn.microboot.controller.util.AbstractBaseController;
import cn.mldn.microboot.service.IMessageService;

@Controller
public class MessageController extends AbstractBaseController {
	@Resource
	private IMessageService messageService;
	
//	@RequestMapping("/show")
//	public String show(Model model) {
//		model.addAttribute("url", "<font color='red'>" + super.getMessage("member.add.page") + "</font>");
//		return "message/show";
//	} 
}
