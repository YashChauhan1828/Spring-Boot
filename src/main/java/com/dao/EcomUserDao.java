package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
		stmt.update("insert into ecomusers(firstName,email,password,profilePicturePath)values(?,?,?,?)",userbean.getFirstName(),
				userbean.getEmail(),userbean.getPassword(),userbean.getProfilePicturePath());
	}

	public EcomUserBean authenticate(String email,String password)
	{
		try 
		{
			EcomUserBean userbean =	stmt.queryForObject("select * from ecomusers where email = ? and password = ? ",
			new BeanPropertyRowMapper<>(EcomUserBean.class),new Object[] {email,password});
		return userbean;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public void updatepassword( String email , String password)
	{
		stmt.update("UPDATE ecomusers SET password = ? where email = ? ",password,email);
	}
}