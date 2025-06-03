package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.EcomPaymentBean;
import com.bean.EcomProductCartBean;
import com.bean.EcomShipping;
import com.bean.EcomUserBean;
import com.dao.EcomShippinDao;
import com.service.EmailService;
import com.service.paymentservice;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class EcomPaymentController 

{

	@Autowired
	EmailService emailservice;
	
	@Autowired
	paymentservice PaymentService;
	
	@Autowired
	EcomShippinDao shippingdao;
	
	
	
	
	@PostMapping("/epayment")
	public String Epayment(EcomPaymentBean paymentbean,HttpSession session)
	{
		System.out.println(paymentbean.getCreditcardnumber());
		System.out.println(paymentbean.getCvv());
		System.out.println(paymentbean.getDate());
		System.out.println(paymentbean.getPrice());
		String email = (String)session.getAttribute("email");
		PaymentService.run(paymentbean,email);
		
		return "Sucess";
	}
	
	@GetMapping("/inputmail")
	public String imputMail() 
	{
		return "InputMail";
	}
	
	@PostMapping("/sendmail")
	public String SendMail(@RequestParam("email") String email,HttpSession session,Model model ) 
	{
		System.out.println(email);
		session.setAttribute("email", email);
		emailservice.sendDemoMail(email, "HI welcome to ABCD");
		Float totalPrice = (Float)session.getAttribute("totalPrice");
		model.addAttribute(totalPrice);
		
		
		return "redirect:/shipping";
	}
	
}
