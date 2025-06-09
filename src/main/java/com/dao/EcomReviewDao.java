package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EcomReviewBean;
import com.bean.EcomReviewProductBean;

@Repository
public class EcomReviewDao 
{
	@Autowired
	JdbcTemplate stmt;
	
	public void addreview(EcomReviewBean reviewbean)
	{
		stmt.update("INSERT INTO reviews (userId, productId, rating, comment) VALUES (?,?,?,?)", reviewbean.getUserId(),
				reviewbean.getProductId(), reviewbean.getRating(), reviewbean.getComment());
	}
	public List<EcomReviewProductBean> getReviewsByProduct(int productId) 
	{
        return stmt.query("select r.*,p.price,p.productName,p.productImagePath from ecomproducts p join reviews r using (productId) where productId= ? ORDER BY createdAt DESC",
                new BeanPropertyRowMapper<>(EcomReviewProductBean.class), productId);
	}
}
