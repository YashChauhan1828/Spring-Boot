package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.EcomShipping;
import com.bean.EcomUserBean;
import com.dao.EcomShippinDao;

import jakarta.servlet.http.HttpSession;

@Controller
public class ShippingController 
{
	@Autowired
	EcomShippinDao shippingdao;
	
	
	@GetMapping("/shipping")
	public String Shipping()
	{
		return "Shipping";
	}
	
	@PostMapping("/eshipping")
	public String Eshipping(EcomShipping shippingbean,HttpSession session,Model model)
	{
		
		EcomUserBean userbean = (EcomUserBean)session.getAttribute("user");
		Integer userID = userbean.getUserId();
		System.out.println(userbean.getUserId());
		shippingbean.setUserId(userID);
		shippingdao.saveDetails(shippingbean);
		EcomShipping ship = shippingdao.getDetails(userID);
		session.setAttribute("ship", ship);
		return "Checkout";
	}
}
