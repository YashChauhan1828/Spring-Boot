package com.bean;

import org.springframework.web.multipart.MultipartFile;

public class EcomUserBean 
{
	private String id;
	private String firstName;
	private String email;
	private String password;
	private MultipartFile profilePicture;
	private String ProfilePicturePath;
	
	public String getProfilePicturePath() {
		return ProfilePicturePath;
	}
	public void setProfilePicturePath(String profilePicturePath) {
		ProfilePicturePath = profilePicturePath;
	}
	public MultipartFile getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(MultipartFile profilePicture) {
		this.profilePicture = profilePicture;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
