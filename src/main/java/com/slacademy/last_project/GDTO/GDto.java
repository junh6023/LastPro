package com.slacademy.last_project.GDTO;

import java.sql.Timestamp;

public class GDto {
	
	private int bg_id;
	private String u_id;
	private String bg_name;
	private float bg_experience;
	private int bg_level;
	private String bg_intro;
	private Timestamp bg_date;
	private int bg_rank;
	

	public int getBg_rank() {
		return bg_rank;
	}
	public void setBg_rank(int bg_rank) {
		this.bg_rank = bg_rank;
	}
	
	public int getBg_id() {
		return bg_id;
	}
	public void setBg_id(int bg_id) {
		this.bg_id = bg_id;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getBg_name() {
		return bg_name;
	}
	public void setBg_name(String bg_name) {
		this.bg_name = bg_name;
	}
	public float getBg_experience() {
		return bg_experience;
	}
	public void setBg_experience(float bg_experience) {
		this.bg_experience = bg_experience;
	}
	public int getBg_level() {
		return bg_level;
	}
	public void setBg_level(int bg_level) {
		this.bg_level = bg_level;
	}
	public String getBg_intro() {
		return bg_intro;
	}
	public void setBg_intro(String bg_intro) {
		this.bg_intro = bg_intro;
	}
	public Timestamp getBg_date() {
		return bg_date;
	}
	public void setBg_date(Timestamp bg_date) {
		this.bg_date = bg_date;
	}
	

	
	
	

}
