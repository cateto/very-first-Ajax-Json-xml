package com.md.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 1. Spring에서 Controller로 인식하게 만듦
public class IndexController {

	@RequestMapping(value="/", method=RequestMethod.GET) // 2. 이 url을 찾아가도록 함.
	public String index() {
		return "index";
	}
	

}
