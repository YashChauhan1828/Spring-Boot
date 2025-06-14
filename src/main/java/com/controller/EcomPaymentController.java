package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.EcomOrderBean;
import com.bean.EcomPaymentBean;
import com.bean.EcomProductBean;
import com.bean.EcomProductCartBean;
import com.bean.EcomShipping;
import com.bean.EcomUserBean;
import com.dao.EcomCartDao;
import com.dao.EcomProductDao;
import com.dao.EcomShippinDao;
import com.service.EmailService;
import com.service.paymentservice;
import com.users.ProductController;
import com.util.Validators;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EcomPaymentController 

{

    private final ProductController productController;

	@Autowired
	EmailService emailservice;
	
	@Autowired
	paymentservice PaymentService;
	
	@Autowired
	EcomShippinDao shippingdao;
	
	@Autowired
	EcomProductDao productdao;
	
	@Autowired
	EcomCartDao cartDao;

    EcomPaymentController(ProductController productController) {
        this.productController = productController;
    }
	
	@GetMapping("/payment")
	public String Payment()
	{
		return"Checkout";
	}
	@PostMapping("/epayment")
	public String Epayment(EcomPaymentBean paymentbean,HttpSession session,Model model )
	{
		boolean isError = false;
		if(Validators.isBlank(paymentbean.getCreditcardnumber()))
		{
			isError = true;
			model.addAttribute("CardError","Enter your card number");
		}
		else if(Validators.isCardValid(paymentbean.getCreditcardnumber())==false)
		{
			isError=true;
			model.addAttribute("CardError","Enter valid card number");
		}
		else
		{
			System.out.println(paymentbean.getCreditcardnumber());
		}
		if(Validators.isBlank(paymentbean.getDate()))
		{
			isError = true;
			model.addAttribute("DateError","Enter Date");
		}
		else if(Validators.isDate(paymentbean.getDate())==false)
		{
			isError = true;
			model.addAttribute("DateError","Enter Valid Date");
		}
		else
		{
			System.out.println(paymentbean.getDate());
		}
		if(Validators.isBlank(paymentbean.getCvv()))
		{
			isError = true;
			model.addAttribute("CVVError","Enter CVV number");
		}
		else if(Validators.isCVV(paymentbean.getCvv())==false)
		{
			isError = true;
			model.addAttribute("CVVError","Enter vaild CVV number");
		}
		else
		{
		System.out.println(paymentbean.getCvv());
		}
		if(isError)
		{
			return"Checkout";
		}
		else
		{
			EcomUserBean userBean = (EcomUserBean)session.getAttribute("user");
			Integer userId = userBean.getUserId();
			List<EcomProductCartBean> cartItems = cartDao.myCart(userId);
			for (EcomProductCartBean item : cartItems) {
//		        EcomProductBean product = new EcomProductBean();
		  
		        productdao.reduceProductQuantity(item.getProductId(), item.getQty());    
		    }
			
			System.out.println(paymentbean.getPrice());
			String email = (String)session.getAttribute("email");
			PaymentService.run(paymentbean,email);
			return "Sucess";
		}
	}
	
	@GetMapping("/inputmail")
	public String imputMail(HttpSession session) 
	{
		EcomUserBean userbean = (EcomUserBean)session.getAttribute("user");
		if(userbean == null)
		{
			return "EcomSignUp";
		}
		else
		{
			return "InputMail";
		}
	}
	
	@PostMapping("/sendmail")
	public String SendMail(@RequestParam("email") String email,HttpSession session,Model model ) 
	{
		EcomUserBean userbean = (EcomUserBean)session.getAttribute("user");
		String Email = userbean.getEmail();
		boolean isError = false ;
		if(Validators.isBlank(email))
		{
			isError = true;
			model.addAttribute("EmailError", "Please Enter your email");
		}
		else if(Validators.isEmail(email)==false) 
		{
			isError = true;
			model.addAttribute("EmailError", "Please Enter valid email");
		}
		else if(email.matches(Email)==false)
		{
			isError = true;
			model.addAttribute("EmailError", "Please Enter user email");
		}
		else
		{
			System.out.println(email);
			session.setAttribute("email", email);
		}
		if(isError)
		{
			return "InputMail";
		}
		else
		{
		emailservice.sendDemoMail(email, "HI welcome to ABCD");
		Float totalPrice = (Float)session.getAttribute("totalPrice");
		model.addAttribute(totalPrice);
		
		
		return "redirect:/shipping";
		}
	}
	
}
