	package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EcomCartBean;
import com.bean.EcomProductBean;
import com.bean.EcomProductCartBean;
import com.bean.EcomUserBean;

@Repository
public class EcomCartDao 
{
	@Autowired
	JdbcTemplate stmt;
	
	public void addToCart(EcomCartBean cartBean) 
	{
		EcomCartBean cart = null;
		try
		{
			cart = stmt.queryForObject("select * from cart where productId = ? and userId = ?",
					new BeanPropertyRowMapper<>(EcomCartBean.class),
					new Object[] { cartBean.getProductId(), cartBean.getUserId() });
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if (cart == null)
		{
			stmt.update("insert into cart (productId , userId , qty) values (?,?,?) ", cartBean.getProductId(),
					cartBean.getUserId(), 1);
		}
		else
		{
			stmt.update("update cart set qty = ? where productId = ? and userId = ?", cart.getQty() + 1,
					cart.getProductId(), cart.getUserId());
		}
		
	}
	
	public List<EcomProductCartBean> myCart(Integer userId)
	{
	List<EcomProductCartBean> products = 	stmt.query("select c.*,p.price,p.productName,p.productImagePath from ecomproducts p join cart c using (productId) where userId= ?",
				new BeanPropertyRowMapper<>(EcomProductCartBean.class), new Object[] { userId });
	return products;
	}
	
	public void deleteproduct(Integer cartId)
	{
		stmt.update(
				"delete from cart where cartId=?",
				cartId);
	}
	
	public void minusQty(Integer cartId) {
		EcomCartBean qty = null;
		try 
		{
			qty = stmt.queryForObject("select * from cart where cartId = ?",
					new BeanPropertyRowMapper<>(EcomCartBean.class), new Object[] { cartId });

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		if(qty.getQty() != 1) 
		{
		
			stmt.update("UPDATE CART SET QTY = ? where cartId = ?" , qty.getQty()-1 ,  cartId);
		}
		else 
		{
			stmt.update("DELETE FROM CART WHERE cartId = ?",cartId);
		}
	}

	public void plusQty(Integer cartId) 
	{
		EcomCartBean qty = null;
		try 
		{
			qty = stmt.queryForObject("select * from cart where cartId = ?",
					new BeanPropertyRowMapper<>(EcomCartBean.class), new Object[] { cartId });

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		stmt.update("UPDATE CART SET QTY = ? where cartId = ?" , qty.getQty()+ 1 ,  cartId);

	}
}
