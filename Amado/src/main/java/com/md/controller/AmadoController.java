package com.md.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class AmadoController {
	
	@GetMapping("cart")
	public String cart() {	
		return "cart";
	}
	@GetMapping("checkout")
	public String checkout() {	
		return "checkout";
	}
	@PostMapping("product-details")
	public String product() {	
		return "product-details";
	}
	@GetMapping("shop")
	public String shop() {	
		return "shop";
	}

	

	
}
