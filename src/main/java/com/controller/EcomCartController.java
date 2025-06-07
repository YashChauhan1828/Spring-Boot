package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.EcomCartBean;
import com.bean.EcomProductBean;
import com.bean.EcomProductCartBean;
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
		if(userbean == null)
		{
			return "EcomSignUp";
		}
		else 
		{
			Integer userID = userbean.getUserId();
			System.out.println(userbean.getUserId());

			EcomCartBean cartBean = new EcomCartBean();
			session.setAttribute("productId", productId);
			cartBean.setProductId(productId);
			cartBean.setUserId(userID);
			cartDao.addToCart(cartBean);

			return "redirect:/userproducts";
		}
	}
	@GetMapping("/mycart")
	public String myCart(HttpSession session , Model model) 
	{
		EcomUserBean userBean = (EcomUserBean)session.getAttribute("user");
		if(userBean == null)
		{
			return "EcomSignUp";
		}
		else 
		{
			
			Integer userId = userBean.getUserId();
			List<EcomProductCartBean> products = cartDao.myCart(userId);
			model.addAttribute("products", products);
			return "MyCart";
		}
	}
	@GetMapping("/removecartitem")
	public String removeCartItem(@RequestParam("cartId") Integer cartId )
	{
		
		cartDao.deleteproduct(cartId);
		return "redirect:/mycart";
	}
	@GetMapping("/minusqty")
	public String minusQty(@RequestParam("cartId") Integer cartId) 
	{
		
		
		cartDao.minusQty(cartId);
		return "redirect:/mycart";
	}
	
	@GetMapping("/plusqty")
	public String plusQty(@RequestParam("cartId") Integer cartId) 
	{
		
		cartDao.plusQty(cartId);
		return "redirect:/mycart";
	}
}
