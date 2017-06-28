package cn.mldn.microboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.mldn.microboot.controller.util.AbstractBaseController;

@Controller
@RequestMapping("/include")
public class IncludeController extends AbstractBaseController {
	@RequestMapping(method = RequestMethod.GET)
	public String include() {
		return "include/include";
	}
}
