package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EcomCartBean;
import com.bean.EcomOrderBean;
import com.bean.EcomOrderProductBean;
import com.bean.EcomProductCartBean;

@Repository
public class EcomOrderDao 
{
	@Autowired
	JdbcTemplate stmt;
	
	
	
	public void order(EcomOrderBean orderBean, int qty) {
	    try {
	        EcomOrderBean existingOrder = stmt.queryForObject(
	            "SELECT * FROM orders WHERE productId = ? AND userId = ?",
	            new BeanPropertyRowMapper<>(EcomOrderBean.class),
	            orderBean.getProductId(), orderBean.getUserId()
	        );

	        // If order exists, skip or update
	    } catch (Exception e) {
	        // Order does not exist, insert new
	        stmt.update(
	            "INSERT INTO orders (productId, userId, qty) VALUES (?, ?, ?)",
	            orderBean.getProductId(), orderBean.getUserId(), qty
	        );
	    }
	}

	public List<EcomOrderProductBean> orderbyid(Integer userId)
	{
	List<EcomOrderProductBean> products = 	stmt.query("select o.*,p.price,p.productName,p.productImagePath from ecomproducts p join orders o using (productId) where userId= ?",
				new BeanPropertyRowMapper<>(EcomOrderProductBean.class), new Object[] { userId });
	return products;
	}
	
}
