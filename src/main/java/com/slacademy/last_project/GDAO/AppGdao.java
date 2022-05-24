package com.slacademy.last_project.GDAO;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.slacademy.last_project.GDTO.GDto;

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

	public ArrayList<GDto> list() {
		String sql="select bg_id, bg_name, u_id,bg_experience, "
				+ " case "
				+ " when bg_experience > 5"
				+ " then '6'"
				+ " when bg_experience > 4"
				+ " then '5'"
				+ " when bg_experience > 3"
				+ " then '4'"
				+ " when bg_experience > 2"
				+ " then '3'"
				+ " when bg_experience > 1"
				+ " then '2'"
				+ " else '1'"
				+ " end as bg_level, bg_intro, bg_date from big_group_list order by bg_id";
		return (ArrayList<GDto>) template.query(sql, new BeanPropertyRowMapper<GDto>(GDto.class));
	}
}
