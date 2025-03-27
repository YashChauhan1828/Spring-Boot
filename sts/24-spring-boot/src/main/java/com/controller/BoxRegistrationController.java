package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.StudentBoxCricketRegistration;

@Controller
public class BoxRegistrationController 
{
	@GetMapping("/boxcricketregistration")
	public String boxregistration()
	{
		return "BoxCricket";
	}
	@PostMapping("/savereg")
	public String saveRegistration (StudentBoxCricketRegistration studentbox,Model model)
	{
		System.out.println(studentbox.getStudentName());
		System.out.println(studentbox.getPlayerType());
		System.out.println(studentbox.getFoodPreference());
		System.out.println(studentbox.getDrink());
		
		boolean isError = false;
		
		if(studentbox.getStudentName() == null || studentbox.getStudentName().trim().length()==0)
		{
			isError = true;
			model.addAttribute("studentNameError","Please enter your name");
		}
		
		if(studentbox.getPlayerType()==null)
		{
			isError = true;
			model.addAttribute("playerTypeError","Please select playing type");
		}
		
		if(studentbox.getFoodPreference().equals("-1"))
		{
			isError = true;
			model.addAttribute("foodPreferenceError","Please select food type");
		}
		
		if(isError)
		{
			return "BoxCricket";
		}
		else
		{
		model.addAttribute("reg",studentbox);
		return "Regdetail";
		}
	}
}
