package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EcomUserBean;

@Repository
public class EcomUserDao 
{
	@Autowired
	JdbcTemplate stmt;
	public void inserUser(EcomUserBean userbean)
	{
		stmt.update("insert into ecomusers(firstName,email,password,profilePic)values(?,?,?,?)",userbean.getFirstName(),
				userbean.getEmail(),userbean.getPassword(),userbean.getProfilePicturePath());
	}
}
