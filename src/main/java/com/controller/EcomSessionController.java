package com.controller;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.EcomUserBean;
import com.dao.EcomUserDao;
import com.service.fileUploadService;
import com.util.Validators;

@Controller
public class EcomSessionController 
{
	@Autowired
	EcomUserDao userdao;
	boolean isError = false;
	
	@Autowired
	fileUploadService FileUploadService;
	
	@GetMapping("esignup")
	public String registration()
	{
		return "EcomSignUp";
	} 
	@PostMapping("esignup")
	public String Signuppost(EcomUserBean userbean,Model model)
	{
		String path = "D:\\sts\\24-spring-boot\\src\\main\\webapp\\images\\profilepicture";
		System.out.println(userbean.getProfilePicture().getOriginalFilename());
		FileUploadService.uploadUserImage(userbean.getProfilePicture(),userbean.getEmail());
		userbean.setProfilePicturePath("images//profilepic//"+userbean.getEmail()+"//"+userbean.getProfilePicture().getOriginalFilename());
		if(Validators.isBlank(userbean.getFirstName()))
		{
			isError = true;
			model.addAttribute("firstNameError","PLease enter your name");
		}
		else if(Validators.isAlpha(userbean.getFirstName())==false)
		{
			isError = true;
			model.addAttribute("firstNameError","PLease enter valid name");
		}
		else
		{
			model.addAttribute("firstNameValue",userbean.getFirstName());
		}

		if(Validators.isBlank(userbean.getEmail()))
		{
			isError = true;
			model.addAttribute("emailError","PLease enter your Email");

		}
		else if(Validators.isEmail(userbean.getEmail())==false)
		{
			isError = true;
			model.addAttribute("emailError","PLease enter valid Email");

		}
		else
		{
			model.addAttribute("emailValue",userbean.getEmail());
		}
		
		if(Validators.isBlank(userbean.getPassword()))
		{
			isError = true;
			model.addAttribute("passwordError","PLease enter your password");

		}
		else if(Validators.isPass(userbean.getPassword())==false)
		{
			isError = true;
			model.addAttribute("passwordError","PLease enter valid password");

		}
		else
		{
			model.addAttribute("passwordValue",userbean.getPassword());
		}
		
		if(isError)
		{
			return "EcomSignUp";
		}
		else
		{
		
			userdao.inserUser(userbean);
			return"EcomLogin";
		}
		
	}
}
