package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.EcomProductCartBean;


@Controller
public class EcomPaymentController 

{
	@GetMapping("/checkout")
	public String Checkout(EcomProductCartBean productcartbean , Model model)
	{
		System.out.println("Quantity : "+productcartbean.getQty());
		System.out.println("Price : "+productcartbean.getPrice());
		model.addAttribute("price",productcartbean);
		return "Checkout";
	}
}
