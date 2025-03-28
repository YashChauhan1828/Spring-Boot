package com.util;

public class Validators 
{
	public static boolean isBlank(String data)
	{
		if(data == null || data.trim().length()==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean isAlpha(String data)
	{
		String alphaRegEx = "[a-zA-Z]+";
		return data.matches(alphaRegEx);
	}
}
