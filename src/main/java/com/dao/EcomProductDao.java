package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EcomProductBean;

@Repository
public class EcomProductDao 
{
	@Autowired
	JdbcTemplate stmt;
	public void addProduct(EcomProductBean productbean) 
	{
		stmt.update("insert into ecomproducts (productName,category,qty,price) values (?,?,?,?)"
				,productbean.getProductName(),productbean.getCategory(),productbean.getQty(),productbean.getPrice());
	}
}
