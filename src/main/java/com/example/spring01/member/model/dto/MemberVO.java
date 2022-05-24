package com.example.spring01.member.model.dto;

import java.sql.Date;

public class MemberVO {
	private String	u_id ; 
	private String u_address ;
	private String	u_pw ;
	private String	u_name ;
	private String	u_check ;
	private int	u_experience ;
	private int	u_level ;
	private int	climb ;
	private Date u_date;
	private int follow ;
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String u_address) {
		this.u_address = u_address;
	}
	public String getU_pw() {
		return u_pw;
	}
	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_check() {
		return u_check;
	}
	public void setU_check(String u_check) {
		this.u_check = u_check;
	}
	public int getU_experience() {
		return u_experience;
	}
	public void setU_experience(int u_experience) {
		this.u_experience = u_experience;
	}
	public int getU_level() {
		return u_level;
	}
	public void setU_level(int u_level) {
		this.u_level = u_level;
	}
	public int getClimb() {
		return climb;
	}
	public void setClimb(int climb) {
		this.climb = climb;
	}
	public Date getU_date() {
		return u_date;
	}
	public void setU_date(Date u_date) {
		this.u_date = u_date;
	}
	public int getFollow() {
		return follow;
	}
	public void setFollow(int follow) {
		this.follow = follow;
	}
	public String get(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Getter/Setter


	
	

}
