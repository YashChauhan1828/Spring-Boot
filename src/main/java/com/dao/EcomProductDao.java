package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
	
	

	public List<EcomProductBean> getAllProducts() {
		List<EcomProductBean> list=	stmt.query("select * from ecomproducts", new BeanPropertyRowMapper<EcomProductBean>(EcomProductBean.class));
		return list;
	}
	
	public void deleteProduct(Integer productId)
	{
		stmt.update("delete from ecomproducts where productId = ?",productId);
	}
	
}
