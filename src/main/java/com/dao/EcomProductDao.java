package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.EcomProductBean;
import com.bean.EcomUserBean;

@Repository
public class EcomProductDao 
{
	@Autowired
	JdbcTemplate stmt;
	public void addProduct(EcomProductBean productbean) 
	{
		stmt.update("insert into ecomproducts (productName,category,qty,price,productImagePath) values (?,?,?,?,?)"
				,productbean.getProductName(),productbean.getCategory(),productbean.getQty(),productbean.getPrice(),productbean.getProductImagePath());
	}
	
	
	
	public List<EcomProductBean> getAllProducts() {
		List<EcomProductBean> list=	stmt.query("select * from ecomproducts LIMIT 9", new BeanPropertyRowMapper<EcomProductBean>(EcomProductBean.class));
		return list;
	}
	
	public List<EcomProductBean> getproductsbycategoryorname( String query )
	{
		 String pattern = "%" + query + "%";
		 System.out.println(pattern);
		List<EcomProductBean> list = stmt.query("SELECT * FROM ecomproducts WHERE LOWER(category) LIKE LOWER(?) OR LOWER(productName) LIKE LOWER(?)",
				new BeanPropertyRowMapper<>(EcomProductBean.class),new Object[] {pattern,pattern});
		return list;
	}
	
	public void deleteProduct(Integer productId)
	{
		stmt.update("delete from ecomproducts where productId = ?",productId);
	}
	
	public void deleteProductByName(String productName)
	{
		stmt.update("delete from ecomproducts where productName = ?",productName);
	}
	
	public EcomProductBean getProductById(Integer productId)
	{
		EcomProductBean bean= stmt.queryForObject("select * from ecomproducts where productId=?", new BeanPropertyRowMapper<>(EcomProductBean.class),new Object[] {productId});
		return bean;
		
	}
}
