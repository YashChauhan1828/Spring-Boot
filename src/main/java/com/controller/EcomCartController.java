package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.EcomCartBean;
import com.bean.EcomUserBean;
import com.dao.EcomCartDao;

import jakarta.servlet.http.HttpSession;

@Controller
public class EcomCartController 
{
	@Autowired
	EcomCartDao cartDao;
	
	
	@GetMapping("/addtocart")
	public String addToCart(@RequestParam("productId") Integer productId, HttpSession session)
	{
		EcomUserBean userbean = (EcomUserBean)session.getAttribute("user");
		Integer userID = userbean.getUserId();
		System.out.println(userbean.getUserId());
		
		EcomCartBean cartBean = new EcomCartBean();
		
		cartBean.setProductId(productId);
		cartBean.setUserId(userID);
		cartDao.addToCart(cartBean);
		
		return"redirect:/userproducts";
	}
}
