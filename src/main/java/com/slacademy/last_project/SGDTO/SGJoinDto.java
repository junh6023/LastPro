package com.slacademy.last_project.SGDTO;

import java.sql.Timestamp;

public class SGJoinDto {

	private int sgj_id;
	private int sg_id;
	private String sg_name;
	private String u_id;
	private Timestamp sgj_date;
	private String y_n;
	private String note;
	public int getSgj_id() {
		return sgj_id;
	}
	public void setSgj_id(int sgj_id) {
		this.sgj_id = sgj_id;
	}
	public int getSg_id() {
		return sg_id;
	}
	public void setSg_id(int sg_id) {
		this.sg_id = sg_id;
	}
	public String getSg_name() {
		return sg_name;
	}
	public void setSg_name(String sg_name) {
		this.sg_name = sg_name;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public Timestamp getSgj_date() {
		return sgj_date;
	}
	public void setSgj_date(Timestamp sgj_date) {
		this.sgj_date = sgj_date;
	}
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
	
	
}
