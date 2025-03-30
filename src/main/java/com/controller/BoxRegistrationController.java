package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.util.Validators;
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
		
		if(Validators.isBlank(studentbox.getStudentName()))
		{
			isError = true;
			model.addAttribute("studentNameError","Please enter your name");
		}
		else if(Validators.isAlpha(studentbox.getStudentName())==false)
		{
			isError = true;
			model.addAttribute("studentNameError","Please enter valid name");
		}
		else
		{
			model.addAttribute("studentNameValue",studentbox.getStudentName());
		}
		
		if(studentbox.getPlayerType()==null)
		{
			isError = true;
			model.addAttribute("playerTypeError","Please select playing type");
		}
		else
		{
			model.addAttribute("playerTypeValue",studentbox.getPlayerType());
		}
		
		if(studentbox.getFoodPreference().equals("-1"))
		{
			isError = true;
			model.addAttribute("foodPreferenceError","Please select food type");
		}
		else
		{
			model.addAttribute("foodPreferenceValue",studentbox.getFoodPreference());
		}
		
		if(Validators.isBlank(studentbox.getDrink()))
		{
			isError = true;
			model.addAttribute("drinkError", "Atleast select one drink");
		}
		else
		{
			model.addAttribute("drinkValue",studentbox.getDrink());
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
