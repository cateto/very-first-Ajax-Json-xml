package com.md.controller;


import java.util.List;

import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;


import com.md.domain.Address;
import com.md.service.AddressAjaxService;

@Controller
@ResponseBody
@RequestMapping("ajax03")
@Log4j
public class AjaxT03Controller {
	@Autowired
	private AddressAjaxService service;
	
	@GetMapping("search01")
	public Address search01(long seq) {
		Address address= service.selectBySeqS(seq);
		return address;
	}
	@PostMapping("search02")
	public List<Address> search02(String name) {
		List<Address> address= service.selectByNameS(name);
		return address;
	}
}
