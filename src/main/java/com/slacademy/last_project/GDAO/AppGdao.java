package com.slacademy.last_project.GDAO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import mountain.mania.com_util.Constant;

public class AppGdao {
	DataSource dataSource;
	JdbcTemplate template;
	
	public AppGdao() {
		this.template = Constant.template;
		try {
			Context context = new InitialContext();
			Context envContext = (Context) context.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/mysql");
			//dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
