package com.haru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("order/")
public class OrderController {
	
	@GetMapping
	public String orderDefault() {
		return "order";
	}

}
