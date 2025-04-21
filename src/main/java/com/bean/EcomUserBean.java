package com.bean;

import org.springframework.web.multipart.MultipartFile;

public class EcomUserBean 
{
	private Integer userId;
	private String firstName;
	private String email;
	private String password;
	private MultipartFile profilePicture;
	private String profilePicturePath;
	
	public String getProfilePicturePath() 
	{
		return profilePicturePath;
	}
	public void setProfilePicturePath(String profilePicturePath) 
	{
		this.profilePicturePath = profilePicturePath;
	}
	public MultipartFile getProfilePicture()
	{
		return profilePicture;
	}
	public void setProfilePicture(MultipartFile profilePicture) 
	{
		this.profilePicture = profilePicture;
	}
	public Integer getUserId() 
	{
		return userId;
	}
	public void setUserId(Integer userId) 
	{
		this.userId = userId;
	}
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
}
