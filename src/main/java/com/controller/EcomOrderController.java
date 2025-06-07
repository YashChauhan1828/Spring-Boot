package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.EcomOrderBean;
import com.bean.EcomOrderProductBean;
import com.bean.EcomProductCartBean;
import com.bean.EcomUserBean;
import com.dao.EcomCartDao;
import com.dao.EcomOrderDao;

import jakarta.servlet.http.HttpSession;

@Controller
public class EcomOrderController 
{
	@Autowired
	EcomOrderDao orderDao;
	
	@Autowired
	EcomCartDao cartDao;
	
	@GetMapping("/orderhistory")
	public String OrderHistory(HttpSession session , Model model) 
	{
		EcomUserBean userBean = (EcomUserBean)session.getAttribute("user");
		
		if(userBean == null)
		{
			return "EcomSignUp";
		}
		else 
		{
			Integer userId = userBean.getUserId();
			List<EcomProductCartBean> cartItems = cartDao.myCart(userId);
			 for (EcomProductCartBean item : cartItems) {
			        EcomOrderBean order = new EcomOrderBean();
			        order.setUserId(userId);
			        order.setProductId(item.getProductId());
			        // You can also store qty, price, etc., if needed
			        orderDao.order(order,item.getQty());
			    }
			
			List<EcomOrderProductBean> products = orderDao.orderbyid(userId);
			model.addAttribute("products", products);
			return "OrderHistory";
		}
	}
}
