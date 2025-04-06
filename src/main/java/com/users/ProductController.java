package com.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.EcomProductBean;
import com.dao.EcomProductDao;

@Controller
public class ProductController 
{
	@Autowired
	EcomProductDao productdao;
	
	@GetMapping("/userproducts")
	public String listproducts(Model model)
	{
		List<EcomProductBean> products =productdao.getAllProducts();
		model.addAttribute("products",products);
		return "EcomHomeProducts";
	}
}
