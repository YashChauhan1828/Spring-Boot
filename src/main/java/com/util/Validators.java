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
		String alphaRegEx ="[a-zA-Z\\sa-zA-Z]+";
		return data.matches(alphaRegEx);
	}
	public static boolean isDigit(String data)
	{
		String alphaRegEx ="[0-9]+";
		return data.matches(alphaRegEx);
	}
	public static boolean isPhone(String data)
	{
		String alphaRegEx = "^\\+?[1-9]\\d{1,14}$";
		return data.matches(alphaRegEx);
	}
	public static boolean isEmail(String data)
	{
		String ERegEx = "[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z0-9]{2,3}";
		return data.matches(ERegEx);
	}
	public static boolean isPass(String data)
	{
		String PRegEx = "[a-zA-Z]+@[0-9]{4}";
		return data.matches(PRegEx);
	}
}
