package com.slacademy.last_project.UBDto;

import java.sql.Timestamp;

public class BDto {

	private int b_id;
	private String u_id;
	private String b_title;
	private String b_content;
	private Timestamp b_date;
	private int b_hit;
	private int b_group;
	private int b_step;
	private int b_indent;
	private String b_lev;
	private String b_img;
	private String b_pw;

	
	
	public BDto(){
		
	}
	public BDto(int bId, String bName, String bTitle, String bContent, Timestamp bDate, int bHit, int bGroup,
			int bStep, int bIndent, String lev,String img,String b_pw) {
		this.b_id = bId;
		this.u_id = bName;
		this.b_title = bTitle;
		this.b_content = bContent;
		this.b_date = bDate;
		this.b_hit = bHit;
		this.b_group = bGroup;
		this.b_step = bStep;
		this.b_indent = bIndent;
		this.b_lev = lev;
		this.b_img = img;
		this.b_pw = b_pw;
	}
	
	
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public Timestamp getB_date() {
		return b_date;
	}
	public void setB_date(Timestamp b_date) {
		this.b_date = b_date;
	}
	public int getB_hit() {
		return b_hit;
	}
	public void setB_hit(int b_hit) {
		this.b_hit = b_hit;
	}
	public int getB_group() {
		return b_group;
	}
	public void setB_group(int b_group) {
		this.b_group = b_group;
	}
	public int getB_step() {
		return b_step;
	}
	public void setB_step(int b_step) {
		this.b_step = b_step;
	}
	public int getB_indent() {
		return b_indent;
	}
	public void setB_indent(int b_indent) {
		this.b_indent = b_indent;
	}
	public String getB_lev() {
		return b_lev;
	}
	public void setB_lev(String b_lev) {
		this.b_lev = b_lev;
	}
	public String getB_img() {
		return b_img;
	}
	public void setB_img(String b_img) {
		this.b_img = b_img;
	}
	public String getB_pw() {
		return b_pw;
	}
	public void setB_pw(String b_pw) {
		this.b_pw = b_pw;
	}
	
}
