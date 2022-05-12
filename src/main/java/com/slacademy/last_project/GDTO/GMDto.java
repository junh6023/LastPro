package com.slacademy.last_project.GDTO;

import java.sql.Timestamp;

public class GMDto {
	private int bgm_id;
	private int bg_id;
	private String bg_name;
	private String u_id;
	private float u_experience;
	private int u_level;
	private Timestamp bgm_date;
	
	
	public int getBgm_id() {
		return bgm_id;
	}
	public void setBgm_id(int bgm_id) {
		this.bgm_id = bgm_id;
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
	public Timestamp getBgm_date() {
		return bgm_date;
	}
	public void setBgm_date(Timestamp bgm_date) {
		this.bgm_date = bgm_date;
	}
	
	
}
