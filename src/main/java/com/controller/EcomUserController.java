package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.EcomProductBean;
import com.dao.EcomProductDao;

@Controller
public class EcomUserController 
{
	@Autowired
	EcomProductDao productdao;
	
	@GetMapping("/ehome")
	public String eHome()
	{
		return "Welcome";
	}
	
	@GetMapping("/userproductview")
	public String userViewProduct(@RequestParam("productId") Integer productId,Model model)
	{
		EcomProductBean productbean =  productdao.getProductById(productId);
		model.addAttribute("product",productbean);
		return "UserViewProduct";
	}
}
