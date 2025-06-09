package com.bean;

public class EcomOrderBean 
{
	private Integer orderId;
	private Integer userId;
	private Integer productId;
	private Integer qty;
	
	public Integer getOrderId() 
	{
		return orderId;
	}
	public void setOrderId(Integer orderId) 
	{
		this.orderId = orderId;
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
	public Integer getQty() 
	{
		return qty;
	}
	public void setQty(Integer qty)
	{
		this.qty = qty;
	}
	
}
