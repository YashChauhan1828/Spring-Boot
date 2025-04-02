 package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.EcomProductBean;
import com.dao.EcomProductDao;

@Controller
public class EcomProductController 
{
	
	@Autowired
	EcomProductDao productdao;
	
	Boolean isError = false;
	
	@GetMapping("/newproduct")
	public String newProduct()
	{
		return "EcomNewProduct";
	}
	
	@PostMapping("/saveproduct")
	public String saveProduct(EcomProductBean productbean,Model model )
	{
		
		productdao.addProduct(productbean);
		return "Welcome";
	}
	
	@GetMapping("/products")
	public String listproducts(Model model)
	{
		List<EcomProductBean> products =productdao.getAllProducts();
		model.addAttribute("products",products);
		return "EcomListProducts";
	}
	
}
