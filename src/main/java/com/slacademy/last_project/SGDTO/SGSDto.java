package com.slacademy.last_project.SGDTO;

import java.sql.Date;

public class SGSDto {

	private int sgs_id;
	private String sgs_title;
	private String m_name;
	private String sg_name;
	private String c_name;
	private String content;
	private Date sgs_date;
	public int getSgs_id() {
		return sgs_id;
	}
	public void setSgs_id(int sgs_id) {
		this.sgs_id = sgs_id;
	}
	public String getSgs_title() {
		return sgs_title;
	}
	public void setSgs_title(String sgs_title) {
		this.sgs_title = sgs_title;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getSg_name() {
		return sg_name;
	}
	public void setSg_name(String sg_name) {
		this.sg_name = sg_name;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getSgs_date() {
		return sgs_date;
	}
	public void setSgs_date(Date sgs_date) {
		this.sgs_date = sgs_date;
	}
	
	
	

}
