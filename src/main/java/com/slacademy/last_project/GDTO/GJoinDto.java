package com.slacademy.last_project.GDTO;

import java.sql.Timestamp;

public class GJoinDto {

	
	private int bgj_id;
	private int bg_id;
	private String bg_name;
	private String u_id;
	private float u_experience;
	private int u_level;
	private Timestamp bgj_date;
	private String y_n;
	private String note;
	
	
	
	
	public String getY_n() {
		return y_n;
	}
	public void setY_n(String y_n) {
		this.y_n = y_n;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getBgj_id() {
		return bgj_id;
	}
	public void setBgj_id(int bgj_id) {
		this.bgj_id = bgj_id;
	}
	public int getBg_id() {
		return bg_id;
	}
	public void setBg_id(int bg_id) {
		this.bg_id = bg_id;
	}
	public String getBg_name() {
		return bg_name;
	}
	public void setBg_name(String bg_name) {
		this.bg_name = bg_name;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public float getU_experience() {
		return u_experience;
	}
	public void setU_experience(float u_experience) {
		this.u_experience = u_experience;
	}
	public int getU_level() {
		return u_level;
	}
	public void setU_level(int u_level) {
		this.u_level = u_level;
	}
	public Timestamp getBgj_date() {
		return bgj_date;
	}
	public void setBgj_date(Timestamp bgj_date) {
		this.bgj_date = bgj_date;
	}
	
	
}
