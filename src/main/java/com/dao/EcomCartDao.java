package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EcomCartBean;

@Repository
public class EcomCartDao 
{
	@Autowired
	JdbcTemplate stmt;
	
	public void addToCart(EcomCartBean cartBean) 
	{
		stmt.update("insert into cart (productId,userId) values (?,?)",cartBean.getProductId(),cartBean.getUserId());
	}
}
