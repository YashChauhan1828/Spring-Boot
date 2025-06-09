package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.EcomProductCartBean;
import com.bean.EcomReviewBean;
import com.bean.EcomReviewProductBean;
import com.bean.EcomUserBean;
import com.dao.EcomCartDao;
import com.dao.EcomReviewDao;

import jakarta.servlet.http.HttpSession;

@Controller
public class EcomReviewController 
{
	@Autowired
	EcomReviewDao reviewdao;
	
	@Autowired
	EcomCartDao cartDao;
	
	@PostMapping("addReview")
	public String Review(@RequestParam("productId") Integer productId,EcomReviewBean reviewbean , HttpSession session,Model model) 
	{
		EcomUserBean userbean = (EcomUserBean)session.getAttribute("user");
		reviewbean.setUserId(userbean.getUserId());
		reviewbean.setProductId(productId);
		reviewdao.addreview(reviewbean);
		List<EcomReviewProductBean> reviews = reviewdao.getReviewsByProduct(productId);
        model.addAttribute("reviews", reviews);
		 return "Review";
	}
	 
	
}
