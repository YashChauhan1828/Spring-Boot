package com.bean;

public class EcomProductBean 
{
	private Integer productId;
	private String productName;
	private String category;
	private Integer qty;
	private float price;
	
	public Integer getProductId() 
	{
		return productId;
	}
	public void setProductId(Integer productId) 
	{
		this.productId = productId;
	}
	public String getProductName() 
	{
		return productName;
	}
	public void setProductName(String productName) 
	{
		this.productName = productName;
	}
	public String getCategory() 
	{
		return category;
	}
	public void setCategory(String category) 
	{
		this.category = category;
	}
	public Integer getQty() 
	{
		return qty;
	}
	public void setQty(Integer qty) 
	{
		this.qty = qty;
	}
	public float getPrice() 
	{
		return price;
	}
	public void setPrice(float price) 
	{
		this.price = price;
	}
}
