package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EcomUserController 
{
	@GetMapping("/ehome")
	public String eHome()
	{
		return "Welcome";
	}
}
