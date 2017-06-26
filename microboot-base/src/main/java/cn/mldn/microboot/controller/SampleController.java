package cn.mldn.microboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	@RequestMapping("/")
	public String home() {
		return "hello World!";
	}

	@RequestMapping("/{msg}")
	public String echo(@PathVariable("msg") String msg) {
		return "echo : " + msg;
	}

	@RequestMapping("/add/{paramA}/{paramB}")
	public Integer add(@PathVariable("paramA") int paramA, @PathVariable("paramB") int paramB) {
		return paramA + paramB * 2;
	}

	@RequestMapping("/print")
	public List<String> print(HttpServletRequest request, HttpServletResponse response) {
		
		List<String> all = new ArrayList<>();
		all.add("客户端IP: " + request.getRemoteAddr());
		all.add("客户端相应编码: " + request.getCharacterEncoding());
		all.add("取得SessionID: " + request.getSession().getId());
		all.add("取得真实路径: " + request.getServletContext().getRealPath("/"));
		return all; 
	}
}
