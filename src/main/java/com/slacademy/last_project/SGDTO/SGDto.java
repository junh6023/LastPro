package com.slacademy.last_project.SGDTO;

import java.sql.Timestamp;

public class SGDto {

	
	private int sg_id;
	private String u_id;
	private String sg_name;
	private String sg_intro;
	private Timestamp sg_date;
	public int getSg_id() {
		return sg_id;
	}
	public void setSg_id(int sg_id) {
		this.sg_id = sg_id;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getSg_name() {
		return sg_name;
	}
	public void setSg_name(String sg_name) {
		this.sg_name = sg_name;
	}
	public String getSg_intro() {
		return sg_intro;
	}
	public void setSg_intro(String sg_intro) {
		this.sg_intro = sg_intro;
	}
	public Timestamp getSg_date() {
		return sg_date;
	}
	public void setSg_date(Timestamp sg_date) {
		this.sg_date = sg_date;
	}
	
	
}
