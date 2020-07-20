package com.md.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.log4j.Log4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.md.domain.Address;
import com.md.service.AddressAjaxService;

@Controller
@RequestMapping("ajax02")
@Log4j
public class AjaxT02Controller {
	@Autowired
	private AddressAjaxService service;
	
	@GetMapping("search01.do")
	public void search01(Long seq, HttpServletResponse response) {
		Address address= service.selectBySeqS(seq);
		ObjectMapper om = new ObjectMapper();
		try {
			String json = om.writeValueAsString(address);
			response.setContentType("application/json;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.print(json);
		}catch(IOException ie) {}
		
	}
	@PostMapping("search02.do")
	public void search02(String name, HttpServletResponse response) {
		List<Address> address= service.selectByNameS(name);
		ObjectMapper om = new ObjectMapper();
		try {
			String json = om.writeValueAsString(address);
			response.setContentType("application/json;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.print(json);
		}catch(IOException ie) {}
	}
}
