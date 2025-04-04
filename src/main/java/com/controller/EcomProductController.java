 package com.controller;

import java.util.List;
import com.service.fileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.EcomProductBean;
import com.dao.EcomProductDao;

@Controller
public class EcomProductController 
{

   
	@Autowired
	EcomProductDao productdao;
	
	@Autowired
	fileUploadService FileUploadService;
	
	Boolean isError = false;
	
	@GetMapping("/newproduct")
	public String newProduct()
	{
		return "EcomNewProduct";
	}
	
	@PostMapping("/saveproduct")
	public String saveProduct(EcomProductBean productbean,Model model,@RequestParam("masterImage") MultipartFile masterImage)
	{
		FileUploadService.uploadproductImage(masterImage);
		productdao.addProduct(productbean);
		return "redirect:/products";
	}
	
	@GetMapping("/products")
	public String listproducts(Model model)
	{
		List<EcomProductBean> products =productdao.getAllProducts();
		model.addAttribute("products",products);
		return "EcomListProducts";
	}
	
	@GetMapping("/deleteproducts")
	public String deleteProduct(@RequestParam("productId") Integer productId)
	{
		System.out.println("deleteProduct()"+productId);
		productdao.deleteProduct(productId);
		return"redirect:/products";
	}
	
	@GetMapping("/deleteproductbyname")
	public String deleteProductByName()
	{
		return "DeleteProductByName";
	}
	
	@PostMapping("/deleteproducts")
	public String deleteProducts(@RequestParam("productName") String productName)
	{
		productdao.deleteProductByName(productName);
		return "redirect:/products";
	}
	
	@GetMapping("/viewproduct")
	public String viewProduct(@RequestParam("productId") Integer productId,Model model)
	{
		EcomProductBean productbean =  productdao.getProductById(productId);
		model.addAttribute("product",productbean);
		return "ViewProduct";
	}
}
