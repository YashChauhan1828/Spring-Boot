package com.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@GetMapping("/search")
	public String Search(@RequestParam("query") String query , Model model)
		{
		if (query == null || query.trim().isEmpty()) 
		{
            return "redirect:/userproducts";
        }
		else 
		{
			
			List<EcomProductBean> products = productdao.getproductsbycategoryorname(query.trim());
			model.addAttribute("products",products);
			return "SearchProducts";
		}
		
		}
}
