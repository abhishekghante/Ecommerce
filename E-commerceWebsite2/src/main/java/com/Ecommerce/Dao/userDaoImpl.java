package com.Ecommerce.Dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Ecommerce.entity.User;

public class userDaoImpl implements userDao {

	@Autowired
	DataSource datasource;
	
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	



	public String addUser(User user) {
		
		try {
			String sql ="insert into user(user_name,user_password,user_email,user_address,mobile) values(?,?,?,?,?)";
			this.template.update(sql,user.getUser_name(),user.getUser_password(),user.getUser_email(),user.getUser_address()
					,user.getMobile());
			return"****";
			
		}catch(Exception e) {
			e.printStackTrace();
			return "Error Registration please contact administrator";
			
		}
		

	}

}
