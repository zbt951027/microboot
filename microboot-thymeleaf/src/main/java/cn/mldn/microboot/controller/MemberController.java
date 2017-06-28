package cn.mldn.microboot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.mldn.microboot.controller.util.AbstractBaseController;
import cn.mldn.microboot.vo.Member;

@Controller
@RequestMapping("/member") 
public class MemberController extends AbstractBaseController {
	@RequestMapping(value="/member_show", method=RequestMethod.GET)
	public String memberShow(Model model) { 
		Member member = new Member();
		member.setAge(20);
		member.setBirthday(new Date());
		member.setMid(1L);
		member.setName("zhasn");
		member.setSalary(99999.9);
		model.addAttribute("member", member);
		return "member/member_show";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String memberList(Model model) {
		List<Member> all = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			Member member = new Member();
			member.setAge(i);
			member.setBirthday(new Date());
			member.setMid(new Random().nextLong());
			member.setName("baitao - " + i);
			member.setSalary(new Random().nextInt(10000) + 10000.0);
			all.add(member);
		}
		model.addAttribute("allMembers", all);
		return "member/member_list"; 
	}
	
	@RequestMapping(value="/set", method=RequestMethod.GET)
	public String memberSet(Model model) {
		Set<String> names = new HashSet<>();
		Set<Integer> ids = new HashSet<>();
		for(int i = 0; i < 10; i++) {
			names.add("baitao - " + i);
			ids.add(i);
		}
		model.addAttribute("names", names);
		model.addAttribute("ids", ids);
		model.addAttribute("mydate", new Date());
		
		return "member/member_set";  
	}
	
	@RequestMapping(value="/map", method=RequestMethod.GET)
	public String memberMap(Model model) {
		Map<String, Member> map = new HashMap<>();
		for(int i = 0; i < 10; i++) {
			Member member = new Member();
			member.setAge(i);
			member.setBirthday(new Date());
			member.setMid(new Random().nextLong());
			member.setName("baitao - " + i);
			member.setSalary(new Random().nextInt(10000) + 10000.0);
			map.put("member - " + i, member);
		}
		model.addAttribute("allMembers", map);
		return "member/member_map"; 
	}
}
