package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.EcomPaymentBean;
import com.bean.EcomProductCartBean;
import com.service.EmailService;
import com.service.paymentservice;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class EcomPaymentController 

{

	@Autowired
	EmailService emailservice;
	
	@Autowired
	paymentservice PaymentService;
	
	@GetMapping("/checkout")
	public String Checkout()
	{
		
		return "Checkout";
	}
	@PostMapping("/epayment")
	public String Epayment(EcomPaymentBean paymentbean)
	{
		System.out.println(paymentbean.getCreditcardnumber());
		System.out.println(paymentbean.getCvv());
		System.out.println(paymentbean.getDate());
		PaymentService.run(paymentbean);
		return "Sucess";
	}
	
	@GetMapping("/inputmail")
	public String imputMail() 
	{
		return "InputMail";
	}
	
	@PostMapping("/sendmail")
	public String SendMail(@RequestParam("email") String email) 
	{
		System.out.println(email);
		emailservice.sendDemoMail(email, "HI welcome to ABCD");
		return "Sucess";
	}
	
}
