package cn.mldn.microboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mldn.microboot.controller.util.AbstractBaseController;
import cn.mldn.microboot.vo.Member;

@Controller
public class MemberController extends AbstractBaseController {
	@RequestMapping(value = "/addpre", method = RequestMethod.GET)
	public String addPre() {
		return "member_add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(@Valid Member vo, Errors error) {
		if (error.hasErrors()) {
			List<ObjectError> errors = error.getAllErrors();
			for (ObjectError err : errors) {
				System.out.println(err.getDefaultMessage());
			}
			return errors; 
		}
		System.out.println(vo);
		return vo;
	}
	
	@RequestMapping("/get")
	@ResponseBody
	public String get() {
		System.out.println("除法计算: " + (10 / 0)); 
		return "hello World!";
	}
}
