package com.bean;

import org.springframework.stereotype.Component;

@Component
public class EcomCartBean 
{
	private Integer cartId;
	private Integer userId;
	private Integer productId;
	private Integer qty;
	
	public Integer getQty() 
	{
		return qty;
	}
	public void setQty(Integer qty) 
	{
		this.qty = qty;
	}
	public Integer getCartId() 
	{
		return cartId;
	}
	public void setCartId(Integer cartId) 
	{
		this.cartId = cartId;
	}
	public Integer getUserId() 
	{
		return userId;
	}
	public void setUserId(Integer userId) 
	{
		this.userId = userId;
	}
	public Integer getProductId() 
	{
		return productId;
	}
	public void setProductId(Integer productId) 
	{
		this.productId = productId;
	}
}
