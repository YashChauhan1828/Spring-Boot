package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EcomShipping;

@Repository
public class EcomShippinDao 
{
	@Autowired
	JdbcTemplate stmt;
	
	public void saveDetails(EcomShipping ecomshippingbean)
	{
		stmt.update("INSERT INTO shipping_details " +
                "(full_name, address_line1, address_line2, city, state, zip_code, country, phone_number,userId) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", ecomshippingbean.getFull_name(),
				ecomshippingbean.getAddress_line1(), ecomshippingbean.getAddress_line2(),
				ecomshippingbean.getCity(),ecomshippingbean.getState(),ecomshippingbean.getZip_code(),
				ecomshippingbean.getCountry(),ecomshippingbean.getPhone_number(),ecomshippingbean.getUserId());
	}
	
	public EcomShipping getDetails(Integer userId)
	{
		EcomShipping bean = stmt.queryForObject("select * from shipping_details where userId = ? LIMIT 1",
				new BeanPropertyRowMapper<>(EcomShipping.class), new Object[] { userId });
		return bean;
	}
}
