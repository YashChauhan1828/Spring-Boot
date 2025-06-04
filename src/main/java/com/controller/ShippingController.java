package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.EcomShipping;
import com.bean.EcomUserBean;
import com.dao.EcomShippinDao;
import com.util.Validators;

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
		boolean isError = false;
		if(Validators.isBlank(shippingbean.getFull_name()))
		{
			isError = true;
			model.addAttribute("NameError","Please Enter Your Name");
		}
		else if(Validators.isAlpha(shippingbean.getFull_name())==false)
		{
			isError = true;
			model.addAttribute("NameError","Please Enter Valid Name");
		}
		else
		{
			System.out.println("Name : "+shippingbean.getFull_name());
		}
		if(Validators.isBlank(shippingbean.getAddress_line1()))
		{
			isError = true;
			model.addAttribute("AddressError","Please Enter Your Address");
		}
		else
		{
			System.out.println("Address : "+shippingbean.getAddress_line1());
		}
		if(Validators.isBlank(shippingbean.getAddress_line2()))
		{
			isError = true;
			model.addAttribute("AddressError","Please Enter Your Address");
		}
		else
		{
			System.out.println("Address : "+shippingbean.getAddress_line2());
		}
		if(Validators.isBlank(shippingbean.getCity()))
		{
			isError = true;
			model.addAttribute("CityError","Please Select Your City");
		}
		else
		{
			System.out.println("City : "+shippingbean.getCity());
		}
		if(Validators.isBlank(shippingbean.getState()))
		{
			isError = true;
			model.addAttribute("StateError","Please Select Your State");
		}
		else
		{
			System.out.println("State : "+shippingbean.getState());
		}
		if(Validators.isBlank(shippingbean.getZip_code()))
		{
			isError = true;
			model.addAttribute("codeError","Please Enter Your ZipCode");
		}
		else if(Validators.isDigit(shippingbean.getZip_code())==false)
		{
			isError = true;
			model.addAttribute("codeError","Please Enter Valid ZipCode");
		}
		else
		{
			System.out.println("Zip Code : "+shippingbean.getZip_code());
		}
		if(Validators.isBlank(shippingbean.getCountry()))
		{
			isError = true;
			model.addAttribute("CountryError","Please Select Your Country");
		}
		else
		{
			System.out.println("State : "+shippingbean.getCountry());
		}
		if(Validators.isBlank(shippingbean.getPhone_number()))
		{
			isError = true;
			model.addAttribute("PhoneError","Please Enter Your Country");
		}
		else if(Validators.isPhone(shippingbean.getPhone_number())==false)
		{
			isError = true;
			model.addAttribute("PhoneError","Please Enter Valid Country");
		}
		else
		{
			System.out.println("Phone : "+shippingbean.getPhone_number());
		}
		if(isError)
		{
			return "Shipping";
		}
		else
		{
		EcomUserBean userbean = (EcomUserBean)session.getAttribute("user");
		Integer userID = userbean.getUserId();
		System.out.println(userbean.getUserId());
		shippingbean.setUserId(userID);
		shippingdao.saveDetails(shippingbean);
		EcomShipping ship = shippingdao.getDetails(userID);
		session.setAttribute("ship", ship);
		return "redirect:/payment";
		}
	}
}
