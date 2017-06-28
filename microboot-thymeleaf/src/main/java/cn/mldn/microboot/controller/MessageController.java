package cn.mldn.microboot.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.mldn.microboot.controller.util.AbstractBaseController;
import cn.mldn.microboot.service.IMessageService;

@Controller
public class MessageController extends AbstractBaseController {
	@Resource
	private IMessageService messageService;
	
	@RequestMapping("/show/{mid}")
	public String show(@PathVariable("mid") String mid, HttpServletRequest request, Model model) {
		model.addAttribute("mid", mid);
		request.setAttribute("requestMsg", "好好学习，天天向上!"); 
		request.getSession().setAttribute("sessionMsg", "我是Session");
		request.getServletContext().setAttribute("applicationMsg", "我是Application");
		model.addAttribute("url", "<font color='red'>" + super.getMessage("member.add.page") + "</font>"); 
		return "message/show"; 
	}
}
