package com.bean;

public class EcomPaymentBean 
{
	private String creditcardnumber;
	private String date;
	private String cvv;
	private Float price;
	
	public Float getPrice() 
	{
		return price;
	}
	public void setPrice(Float price) 
	{
		this.price = price;
	}
	public String getCreditcardnumber() 
	{
		return creditcardnumber;
	}
	public void setCreditcardnumber(String creditcardnumber) 
	{
		this.creditcardnumber = creditcardnumber;
	}
	public String getDate() 
	{
		return date;
	}
	public void setDate(String date) 
	{
		this.date = date;
	}
	public String getCvv() 
	{
		return cvv;
	}
	public void setCvv(String cvv) 
	{
		this.cvv = cvv;
	}
}
