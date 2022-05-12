package com.slacademy.last_project.GDTO;

import java.sql.Date;

public class GSDto {

	private int bgs_id;
	private String bgs_title;
	private String m_name;
	private String bg_name;
	private String c_name;
	private String content;
	private Date bgs_date;

	
	
	
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public int getBgs_id() {
		return bgs_id;
	}
	public void setBgs_id(int bgs_id) {
		this.bgs_id = bgs_id;
	}
	public String getBgs_title() {
		return bgs_title;
	}
	public void setBgs_title(String bgs_title) {
		this.bgs_title = bgs_title;
	}
	
	
	
	public String getBg_name() {
		return bg_name;
	}
	public void setBg_name(String bg_name) {
		this.bg_name = bg_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getBgs_date() {
		return bgs_date;
	}
	public void setBgs_date(Date bgs_date) {
		this.bgs_date = bgs_date;
	}

	
}
