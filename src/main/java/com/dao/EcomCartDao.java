package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EcomCartBean;
import com.bean.EcomProductBean;

@Repository
public class EcomCartDao 
{
	@Autowired
	JdbcTemplate stmt;
	
	public void addToCart(EcomCartBean cartBean) 
	{
		stmt.update("insert into cart (productId,userId) values (?,?)",cartBean.getProductId(),cartBean.getUserId());
	}
	
	public List<EcomProductBean> myCart(Integer userId)
	{
	List<EcomProductBean> products = 	stmt.query("select * from ecomproducts join cart using (productId) where userId=?",
				new BeanPropertyRowMapper<>(EcomProductBean.class), new Object[] { userId });
	return products;
	}
	
	public void deleteproduct(Integer productId)
	{
		stmt.update("DELETE cart FROM cart JOIN ecomproducts ON cart.productId = ecomproducts.productId WHERE cart.productId = ?",productId);
	}
}
