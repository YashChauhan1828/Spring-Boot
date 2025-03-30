package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;

@Controller
public class SessionController 
{
	@GetMapping("/login")
	public String login()
	{
		return "Login";
	}
	@GetMapping("/signup")
	public String signup()
	{
		return "SignUp";
	}
	@GetMapping("/fp")
	public String fp()
	{
		return "ForgetPassword";
	}
	@PostMapping("/saveUser")
	public String saveUser(UserBean userbean,Model model)
		{
			System.out.println("Firstname:"+userbean.getFirstName());
			System.out.println("Email:"+userbean.getEmail());
			System.out.println("Password:"+userbean.getPassword());
			
			model.addAttribute("user",userbean);
			return "Welcome";
		}
}
